package com.example.spring_calc.controller;


import com.example.spring_calc.component.Calculator;
import com.example.spring_calc.dto.ReqDTO;
import com.example.spring_calc.dto.ResDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CalculatorController {

    private final Calculator calculator;

    @GetMapping("/sum")
    public  int sum(@RequestParam int x , @RequestParam int y){

        return calculator.sum(x,y);

    }


    @PostMapping("/minus")
    public ResDTO minus(ReqDTO reqDTO){

        int result = calculator.minus(reqDTO.getX(),reqDTO.getY());

        ResDTO res = new ResDTO();
        res.setResult(result);

        res.setResponse(new ResDTO.Body());

        return res;
    }
}
