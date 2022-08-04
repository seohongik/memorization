package com.example.filter.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = {"/api/user/ *"})
public class GlobalFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        ContentCachingRequestWrapper httpServletRequest = new ContentCachingRequestWrapper((HttpServletRequest) request);
        ContentCachingResponseWrapper httpServletResponse = new ContentCachingResponseWrapper ((HttpServletResponse) response);

        //전처리
        String url = httpServletRequest.getRequestURI();


        /*
        BufferedReader br = httpServletRequest.getReader();

        br.lines().forEach(line->{

            log.info("url :{} ,line :{}",url, line);

        });
        */

        chain.doFilter(httpServletRequest,httpServletResponse);

        //후처리

        String reqContent  = new String(httpServletRequest.getContentAsByteArray());

        log.info("request url : {}, request body : {}",url,reqContent);

        String respContent = new String(httpServletResponse.getContentAsByteArray());

        int httpStatus = httpServletResponse.getStatus();

        log.info("response status :{}, responseBody:{}",httpStatus,respContent);

        // 한번 읽어버렸기 때문에 바디 내려줄때 사용 반드시
        httpServletResponse.copyBodyToResponse();

    }


}
