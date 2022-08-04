package com.example.interceptor.interceptor;

import com.example.interceptor.annotation.Auth;
import com.example.interceptor.exception.AuthException;
import com.sun.jndi.toolkit.url.Uri;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.util.UriBuilderFactory;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;


@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getRequestURI();
        URI uri = UriComponentsBuilder.fromUriString(url).query(request.getQueryString()).build().toUri();


        log.info("uri:{}",url);

        boolean hasAnnotation = checkAnnotation(handler, Auth.class);

        log.info("has annotation :{}",hasAnnotation);

        //나의 서버는 모두 public으로 동작하는데
        //단 Auth 권한을 가진 요청에 대해서는 세션 쿠기
        if(hasAnnotation){
            //권한 체크
            String query  =uri.getQuery();
            log.info("query : {}",query);

            if(query.equals("name=steve")){

                return true;
            }
            throw new AuthException();


        }


        //return false 일 경우 리턴 시킨다.
        return true;
    }

    private boolean checkAnnotation(Object handler,Class clazz){

        //resource javascript html

        if(handler instanceof ResourceHttpRequestHandler){
            return true;
        }

        //annotaion
        HandlerMethod handlerMethod = (HandlerMethod) handler;

        if(handlerMethod.getMethodAnnotation(clazz)!=null || handlerMethod.getBeanType().getAnnotation(clazz)!=null){
            //Auth annotaion 이 있을때 통과
            return true;
        }

        return false;
    }
}
