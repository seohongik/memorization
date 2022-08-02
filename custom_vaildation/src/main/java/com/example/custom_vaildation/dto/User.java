package com.example.custom_vaildation.dto;

import com.example.custom_vaildation.annotaion.YearMonth;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.SimpleFormatter;

public class User {
    /* 다른 객체를 참조하고 있을땐 @Valid를 붙여야 한다
    @Valid
    List<Car> carList;
   */
    @NotBlank
    private String name;
    @Min(value = 10)
    @Max(value = 90)
    private int age;
    @Email
    private String email;
    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호의 양식과 맞지 않습니다. 01x-xxxx-xxxx")
    private String phoneNumber;

    @YearMonth(pattern = "yyyyMM")
    private String reqYearMonth; //yyyyMM

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getReqYearMonth() {
        return reqYearMonth;
    }

    public void setReqYearMonth(String reqYearMonth) {
        this.reqYearMonth = reqYearMonth;
    }


    //@AssertTrue(message =  "yyyyMM의 형식에 맞지 않습니다.") //@AssertTrue를 사용하려면 boolean는 매소드명에 is를 붙여야 한다 꼭!!!!
    public boolean isReqYearMonthValidation(){
        this.reqYearMonth = getReqYearMonth();
        try {
            LocalDate localDate = LocalDate.parse(reqYearMonth+"01", DateTimeFormatter.ofPattern("yyyyMMdd"));
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", reqYearMonth='" + reqYearMonth + '\'' +
                '}';
    }
}
