package com.example.custom_vaildation.controller;

import com.example.custom_vaildation.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ApiController {


    @PostMapping("/user")
    public ResponseEntity user(@Valid @RequestBody User user, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            StringBuilder sb = new StringBuilder();

            bindingResult.getAllErrors().forEach(objectError -> {
                FieldError field = (FieldError) objectError;
                String msg = objectError.getDefaultMessage();
                System.out.println("field : "+field.getField());
                System.out.println(msg);
                sb.append("field  :" +field.getField());
                sb.append("\n");
                sb.append("message :"+msg);
            });

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
        }
        System.out.println(user);

        return ResponseEntity.ok(user);
    }

    /* 검증할 필드가 늘어날 경우 복잡해짐
    @PostMapping("/user")
    public ResponseEntity user(@RequestBody  User user){

        if(user.getAge()>=90){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
        }
        return ResponseEntity.ok(user);
    }*/

}
