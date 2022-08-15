package com.example.client.dto;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Req<T> {

    private Header header;
    private T realBody;

    @Getter
    @Setter
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static  class Header{
        public Map<String,String> map;

    }
}
