package com.example.spring_calc.component;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;


@SpringBootTest
@Import({MarketApi.class,DollarCalculator.class})
public class DollarCalculatorTest {

  /*  @MockBean
    private MarketApi marketApi;

    @Autowired
    private DollarCalculator dollarCalculator;


    @Test
    public void dollarCalculatorTest(){

        Mockito.lenient().when(marketApi.connect()).thenReturn(3000);

        dollarCalculator.init();
        int sum =dollarCalculator.sum(10,10);

        int minus =dollarCalculator.minus(10,10);



        Assertions.assertEquals(60000,sum);

        Assertions.assertEquals(0,minus);


    }*/


}
