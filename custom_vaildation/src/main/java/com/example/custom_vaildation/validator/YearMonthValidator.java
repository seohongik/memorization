package com.example.custom_vaildation.validator;

import com.example.custom_vaildation.annotaion.YearMonth;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class YearMonthValidator implements ConstraintValidator<YearMonth,String> {

    private String pattern;

    @Override
    public void initialize(YearMonth constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //yyyyMM annotaion defult value 로 yyyyMMdd를 붙히는 방법도 있다.

        System.out.println(pattern);
        StringBuilder sb = new StringBuilder();
        sb.append(pattern);
        sb.append("dd");
        try {
            LocalDate localDate = LocalDate.parse(value+"01", DateTimeFormatter.ofPattern(sb.toString()));
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
