package com.example.server.controller;

import com.example.server.dto.Req;
import com.example.server.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/server")
public class ApiControllerServer {

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
