package org.delivery.api.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class LoggerFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        var req = new ContentCachingRequestWrapper((HttpServletRequest) request);
        var res = new ContentCachingResponseWrapper((HttpServletResponse) response);
        log.info("INIT : {}", req.getRequestURI()); // 오류 발생시 Filter를 가장 먼저 통과함을 출력하기 위한 로그

        chain.doFilter(req,res);

        //request 정보
        var headerNames = req.getHeaderNames();
        var headerValues = new StringBuilder();

        headerNames.asIterator().forEachRemaining(headerKey -> {
            var headerValue = req.getHeader(headerKey);

            // authorization-token : ??? , user-agent : ???
            headerValues.append("[").append(headerKey)
                    .append(" : ")
                    .append(headerValue)
                    .append("] ");
        });

        var requestBody = new String(req.getContentAsByteArray());
        var uri = req.getRequestURI();
        var method = req.getMethod();


        log.info(">>>> uri : {} , method : {} , header : {} , body : {}",uri,method,headerValues.toString(),requestBody);

        // response 정보
        var responseHeaderValues = new StringBuilder();

        res.getHeaderNames().forEach(headerKey -> {
            var headerValue = res.getHeader(headerKey);
            responseHeaderValues
                    .append(" [")
                    .append(headerKey)
                    .append(" : ")
                    .append(headerValue)
                    .append("] ");
        });

        var responseBody = new String(res.getContentAsByteArray());

        // Request -> Filter -> DispatcherServlet -> Handler Interceptor -> Controller -> Exception Handler -> DispatcherServlet -> Filter -> Response
        log.info("<<<< uri : {} , method : {} , header : {} , body : {}",uri, method, responseHeaderValues, responseBody);

        res.copyBodyToResponse(); // 이걸 안쓰면 response-body가 비어있는 채로 전달된다.

    }
}
