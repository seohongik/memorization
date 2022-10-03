package com.example.server.controller;

import com.example.server.dto.Req;
import com.example.server.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/server")
public class ApiControllerServer {

    @GetMapping("/naver")
    public Object never(){

        String query = "중국집";
        URI uri = UriComponentsBuilder
                .fromUriString("https://openapi.naver.com")
                .path("/v1/search/local.json")
                .queryParam("query",query)
                .queryParam("display",10)
                .queryParam("start",1)
                .queryParam("sort","random")
                .encode(Charset.forName("UTF-8"))
                .build()
                .toUri();

        log.error("uri:{}",uri);

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();

        headers.add("X-Naver-Client-Id","");
        headers.add("X-Naver-Client-Secret","");

        RequestEntity<Void> requestEntity = RequestEntity.get(uri)
                .headers(headers)
                .build();
        ResponseEntity<String> result = restTemplate.exchange(requestEntity,String.class);

        log.error("body:{}",result.getBody());

        return result.getBody();
    }

    @GetMapping("/hello")
    public User hello(@RequestParam String name, @RequestParam int age){

        User user = new User();
        user.setAge(age);
        user.setName(name);
        return user;
    }

    @PostMapping ("/user/{userId}/name/{userName}")
    public User post(@RequestBody User user,
                     @PathVariable int userId,
                     @PathVariable String userName){

        log.info("userId : {}, userName : {}",userId, userName);
        log.info("client req :{}",user);
        return user;
    }

    @PostMapping ("/user/{userId}/name/{userName}/type/{type}")
    public User exchange(@RequestBody User user,
                         @PathVariable int userId,
                         @PathVariable String userName,
                         @PathVariable String type,
                         @RequestHeader("x-authorization") String authorization,
                         @RequestHeader("custom-header")String customHeader){

        log.info("userId : {}, userName : {} , type :{}",userId, userName,type);
        log.info("authorization : {}, customHeader : {}",authorization, customHeader);
        log.info("client req :{}",user);
        return user;
    }

    @PostMapping ("/user/{userId}/name/{userName}/type/{type}/generic/{generic}")
    public Req<User> genericExchange(
                         //HttpEntity<String> httpEntity,
                         @RequestBody Req<User> user,
                         @PathVariable int userId,
                         @PathVariable String userName,
                         @PathVariable String type,
                         @RequestHeader("x-authorization") String authorization,
                         @RequestHeader("custom-header")String customHeader) throws InstantiationException, IllegalAccessException {


        //log.info("httpEntity : {}",httpEntity.getBody());
        log.info("userId : {}, userName : {} , type :{}",userId, userName,type);
        log.info("authorization : {}, customHeader : {}",authorization, customHeader);
        log.info("client req :{}",user);

        Req<User> response = new Req<>();
        Req.Header header = new Req.Header();

        Map<String, String> map = new HashMap<>();
        map.put("headerOk", "200");
        map.put("status","ok");
        header.setMap(map);

        response.setHeader(header);
        response.setRealBody(user.getRealBody());

        return response;
    }

}
