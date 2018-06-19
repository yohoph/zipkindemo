package org.yohoph.demo.tracking;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;

import java.io.IOException;

/**
 * @author yehao
 * @version 1.0
 * @date 2018/6/13 11:13
 * @Description HttpRestTemplate拦截器
 */
public class HttpTemplateInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        HttpRequestWrapper requestWrapper = new HttpRequestWrapper(httpRequest);
        requestWrapper.getHeaders().add(TrackingRuntime.TRACKING_REST_HEADER, "RestTemplate");
        return  clientHttpRequestExecution.execute(requestWrapper, bytes);
    }
}
