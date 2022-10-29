package com.example.spring_calc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResDTO {

    private int result;

    private  Body response;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Body{

        private String resultCode ="OK";



    }
}
