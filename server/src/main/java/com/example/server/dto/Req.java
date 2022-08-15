package com.example.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Req<T> {

    private Header header;

    private T realBody;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Header{

        /*
        public String headerOk;
        public String status;
        */

        public Map<String,String> map;

    }

}
