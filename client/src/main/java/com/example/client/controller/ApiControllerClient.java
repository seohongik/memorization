package com.example.client.controller;


import com.example.client.dto.Req;
import com.example.client.dto.UserResponse;
import com.example.client.service.RestTemplateService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class ApiControllerClient {

    private final RestTemplateService restTemplateService;

    public ApiControllerClient(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    @GetMapping("hello-toGet")
    public UserResponse getHello(){

        return restTemplateService.hello();
    }

    @GetMapping("hello-toExchange")
    public UserResponse postHello(){

        return restTemplateService.exchange();
    }

    @GetMapping("hello-toGenericExchange")
    public Req<UserResponse> genericExchange(){

        return restTemplateService.genericExchange();
    }

    //genericExchange

}
