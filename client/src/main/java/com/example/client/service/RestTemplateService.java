package com.example.client.service;

import com.example.client.dto.Req;
import com.example.client.dto.UserRequest;
import com.example.client.dto.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class RestTemplateService {

    //http://localhost/api/server/hello

    public UserResponse hello(){
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/hello")
                .queryParam("name","hong")
                .queryParam("age",20)
                .encode()
                .build()
                .toUri();
        log.info("uri  : {}", uri.toString());

        RestTemplate restTemplate = new RestTemplate();

        //String result= restTemplate.getForObject(uri,String.class);
        /*
        ResponseEntity<String> result=restTemplate.getForEntity(uri,String.class);

        log.info("result :{}",result);
        log.info("result getStatusCode :{}",result.getStatusCode());
        log.info("result getBody :{}",result.getBody());
        */

        ResponseEntity<UserResponse> result=restTemplate.getForEntity(uri,UserResponse.class);

        log.info("result :{}",result);
        log.info("result getStatusCode :{}",result.getStatusCode());
        log.info("result getBody :{}",result.getBody());
        return result.getBody();
    }

    //http://localhost/api/server/user/{userid}/name/{userName}
    public UserResponse post(){
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100,"hong")
                //.expand("steve") 이렇게 계속 붙이는게 아니라 컴마 사용
                .toUri();
        log.info("uri  : {}", uri.toString());

        //http body -> object -> objectmapper -> json -> restemplate-> http body->json

        UserRequest userRequest = new UserRequest();

        userRequest.setAge(10);
        userRequest.setName("steve");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponse> response = restTemplate.postForEntity(uri,userRequest,UserResponse.class);

        log.info("result :{}",response);
        log.info("result getStatusCode :{}",response.getStatusCode());
        log.info("result getHeader :{}",response.getHeaders());
        log.info("result getBody :{}",response.getBody());
        return  response.getBody();
    }

    public  UserResponse exchange(){

        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}/type/{type}")
                .encode()
                .build()
                .expand(100,"hong","exchange")
                //.expand("steve") 이렇게 계속 붙이는게 아니라 컴마 사용
                .toUri();
        log.info("uri  : {}", uri.toString());

        //http body -> object -> objectmapper -> json -> restemplate-> http body->json

        UserRequest userRequest = new UserRequest();

        userRequest.setAge(10);
        userRequest.setName("steve");

        RequestEntity<UserRequest> requestEntity = RequestEntity.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization","hongc")
                .header("custom-header","jericho")
                .body(userRequest);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponse> response = restTemplate.exchange(requestEntity,UserResponse.class);

        return response.getBody();

    }

    public Req<UserResponse> genericExchange(){

        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}/type/{type}/generic/{generic}")
                .encode()
                .build()
                .expand(100,"hong","exchange","generic")
                //.expand("steve") 이렇게 계속 붙이는게 아니라 컴마 사용
                .toUri();
        log.info("uri  : {}", uri.toString());

        //http body -> object -> objectmapper -> json -> restemplate-> http body->json

        UserRequest userRequest = new UserRequest();
        userRequest.setAge(10);
        userRequest.setName("steve");

        Map<String,String> map = new HashMap<>();

        map.put("headerOk", "headerOk");
        map.put("status", "status");


        Req<UserRequest> req = new Req();
        req.setHeader(new Req.Header(map));
        req.setRealBody(userRequest);

        RequestEntity<Req<UserRequest>> requestEntity = RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization","hongc")
                .header("custom-header","jericho")
                .body(req);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Req<UserResponse>> response
                = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<Req<UserResponse>>(){});

        return response.getBody();
    }
}
