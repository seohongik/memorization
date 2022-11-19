package com.bookofficial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/good")
public class HomeController {

    @RequestMapping("/test")
    public @ResponseBody String homeTest() {


        return "Spring + Maven";
    }


    @RequestMapping("/readMain")
    public String readMain(){


        return "/readMain";
    }

    @RequestMapping("/unReadMain")
    public String unReadMain(){


        return "unReadMain";
    }

    @RequestMapping("/report")
    public String report(){


        return "report";
    }

    @RequestMapping("/reportResult")
    public String reportResult(){


        return "result";
    }



}
