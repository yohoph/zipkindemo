package org.yohoph.demo.tracking;

import brave.Span;
import brave.Tracer;
import brave.http.HttpTracing;
import brave.propagation.TraceContext;
import com.jmsw.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yehao
 * @version 1.0
 * @date 2018/6/13 11:13
 * @Description 服务端拦截器
 */
public class ServerInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private Tracer tracer;

    private Span span;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //只有服务端过来的请求才记录span
        if(StringUtils.isEmpty(getSpanHeader(request))){
            String requestUrl = request.getRequestURI();
            span = tracer.nextSpan().name(requestUrl).start();
            span.start();
            TrackingRuntime.put(TrackingRuntime.TRACKING_ID , span.context().spanId());
        }
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if(span == null) {
            return ;
        }
        if(ex != null){
            span.error(ex);
        }
        span.finish();
    }

    private String getSpanHeader(HttpServletRequest request){
        String serverHeader = request.getHeader(TrackingRuntime.TRACKING_REST_HEADER);
        return serverHeader;
    }

}
