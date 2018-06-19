package org.yohoph.demo.tracking;

import brave.SpanCustomizer;
import brave.Tracing;
import brave.context.log4j2.ThreadContextCurrentTraceContext;
import brave.http.HttpTracing;
import brave.propagation.B3Propagation;
import brave.propagation.ExtraFieldPropagation;
import brave.spring.web.TracingClientHttpRequestInterceptor;
import brave.spring.webmvc.HandlerParser;
import brave.spring.webmvc.SpanCustomizingAsyncHandlerInterceptor;
import com.jmsw.common.utils.IdGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import zipkin2.Span;
import zipkin2.reporter.AsyncReporter;
import zipkin2.reporter.Sender;
import zipkin2.reporter.okhttp3.OkHttpSender;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yehao
 * @version 1.0
 * @date 2018/6/11 17:44
 * @Description TODO (这里用一句话描述这个方法的作用)
 */
@Configuration
@Import({
        TracingClientHttpRequestInterceptor.class,
        SpanCustomizingAsyncHandlerInterceptor.class
})
public class TracingConfiguration implements WebMvcConfigurer {

    @Bean
    public Sender sender(){
        return OkHttpSender.create("http://192.168.20.186:9411/api/v2/spans");
    }

    @Bean
    AsyncReporter<Span> spanReporter() {
        return AsyncReporter.create(sender());
    }

    @Bean
    Tracing tracing(@Value("${zipkin.service:brave-webmvc-example}") String serviceName) {
        return Tracing.newBuilder()
                .localServiceName(serviceName)
                .propagationFactory(ExtraFieldPropagation.newFactory(B3Propagation.FACTORY, "user-name"))
                .currentTraceContext(ThreadContextCurrentTraceContext.create()) // puts trace IDs into logs
                .spanReporter(spanReporter()).build();
    }

    @Bean
    HttpTracing httpTracing(Tracing tracing) {
        return HttpTracing.create(tracing);
    }

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    TracingClientHttpRequestInterceptor clientInterceptor;

    @PostConstruct
    public void init() {
        List<ClientHttpRequestInterceptor> interceptors =
                new ArrayList<>(restTemplate.getInterceptors());
        interceptors.add(clientInterceptor);
        restTemplate.setInterceptors(interceptors);
    }

    @Autowired
    SpanCustomizingAsyncHandlerInterceptor serverInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(serverInterceptor);
    }

    @Bean
    HandlerParser handlerParser(){
        HandlerParser handlerParser = new HandlerParser(){
            @Override
            protected void preHandle(HttpServletRequest request, Object handler, SpanCustomizer customizer) {
                String span = request.getHeader("myspan");
                if(span == null){
                    String uri = request.getRequestURI();
                    span = uri + IdGen.uuid();
                }
                super.preHandle(request, handler, customizer);
            }
        };
        return handlerParser;
    }


}
