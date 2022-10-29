package com.example.spring_calc.controller;

import com.example.spring_calc.component.Calculator;
import com.example.spring_calc.component.DollarCalculator;
import com.example.spring_calc.component.MarketApi;
import com.example.spring_calc.dto.ReqDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

//SpringBootTest 는 모든 빈이 다 등록되지만(통시테스트에 적합) WebMvcTest 는 단위테스트가 가능하다
@WebMvcTest(CalculatorController.class)
@AutoConfigureWebMvc
@Import({Calculator.class, DollarCalculator.class })
public class CalculatorControllerTest {

    @MockBean
    public MarketApi marketApi;

    @Autowired
    private CalculatorController controller;

    public MockMvc mockMvc;

    @Before
    public  void  init(){
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        //예전에는 MockMvc 바로 @Autowired로 주입 할 수 있었는데  MockMvc가 final이 되면서 불가해서 꼭 상기 코드가 필요하다.

        Mockito.when(marketApi.connect()).thenReturn(3000);
    }

    @Test
    public void sumTest() throws Exception {

        /*
        mockMvc.perform(
                MockMvcRequestBuilders.get("http://localhost:8080/api/sum")

        ).andExpect(

                MockMvcResultMatchers.status().isOk()
        ).andExpect(

                MockMvcResultMatchers.content().string("60000")
        ).andDo(MockMvcResultHandlers.print());*/

        init();
        mockMvc.perform(
                MockMvcRequestBuilders.get("http://localhost:8080/api/sum")
                        .queryParam("x", String.valueOf(10)).queryParam("y", String.valueOf(10))
        ).andExpect(

                MockMvcResultMatchers.status().isOk()
        ).andExpect(

                MockMvcResultMatchers.content().string("60000")
        ).andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void minusTest() throws Exception {

        init();

        ReqDTO reqDTO = new ReqDTO();

        reqDTO.setX(10);
        reqDTO.setY(10);

        String json = new ObjectMapper().writeValueAsString(reqDTO);


        mockMvc.perform(
                MockMvcRequestBuilders
                        .post("http://localhost:8080/api/minus")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)

        ).andExpect(

                MockMvcResultMatchers.status().isOk()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.result").value(0)


        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.response.resultCode").value("OK")

        ).andDo(MockMvcResultHandlers.print());


    }

}
