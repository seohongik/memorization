package com.example.exception.advice;

import com.example.exception.controller.ApiController;
import com.example.exception.dto.Error;
import com.example.exception.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@RestControllerAdvice(basePackageClasses = ApiController.class) //Global 하게 에러 잡음 만약 지역적으로 에러 잡고 싶으면 컨트롤러 클레스 안에 익셉션 헨들러 작성
//@ControllerAdvice //뷰 리졸버를 사용하면 컨트롤러 어드바이스
public class ApiControllerAdvice {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exception(Exception e){

        System.out.println(e.getClass().getName());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");

    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest httpServletRequest){

        List<Error> errorList = new ArrayList<>();



        BindingResult bindingResult = e.getBindingResult();

        bindingResult.getAllErrors().forEach(error->{

            FieldError field = (FieldError) error;

            String fieldName = field.getField();

            String message = field.getDefaultMessage();

            String value = field.getRejectedValue().toString();

            System.out.println(" fieldName :  "+fieldName);
            System.out.println(" message :  "+message);
            System.out.println(" value :  "+value);

            Error errorMsg =new Error();
            errorMsg.setField(fieldName);
            errorMsg.setMessage(message);
            errorMsg.setInvalidValue(value);

            errorList.add(errorMsg);
        });

        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setErrorList(errorList);
        errorResponse.setMessage("");
        errorResponse.setRequestUrl(httpServletRequest.getRequestURI());
        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.toString());
        errorResponse.setResultCode("FAIL");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);

    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity constraintViolationException(ConstraintViolationException e,HttpServletRequest httpServletRequest){

        List<Error> errorList = new ArrayList<>();


        e.getConstraintViolations().forEach(error->{

            Stream<Path.Node> stream = StreamSupport.stream(error.getPropertyPath().spliterator(),false);

            List<Path.Node> list = stream.collect(Collectors.toList());

            String field = list.get(list.size()-1).getName();

            String message = error.getMessage();

            String invalidValue = error.getInvalidValue().toString();

            System.out.println("  field :  "+field);
            System.out.println("  message : "+message);
            System.out.println("  invalidValue : "+invalidValue);

            Error errorMsg =new Error();
            errorMsg.setField(field);
            errorMsg.setMessage(message);
            errorMsg.setInvalidValue(invalidValue);

            errorList.add(errorMsg);

        });

        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setErrorList(errorList);
        errorResponse.setMessage("");
        errorResponse.setRequestUrl(httpServletRequest.getRequestURI());
        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.toString());
        errorResponse.setResultCode("FAIL");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);

    }


    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResponseEntity missingServletRequestParameterException(MissingServletRequestParameterException e, HttpServletRequest httpServletRequest){

        String fieldName = e.getParameterName();

        String fieldType = e.getParameterType();

        String invalidValue = e.getMessage();

        List<Error> errorList = new ArrayList<>();

        Error errorMsg =new Error();
        errorMsg.setField(fieldName);
        errorMsg.setMessage(fieldType);
        errorMsg.setInvalidValue(invalidValue);

        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setErrorList(errorList);
        errorResponse.setMessage("");
        errorResponse.setRequestUrl(httpServletRequest.getRequestURI());
        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.toString());
        errorResponse.setResultCode("FAIL");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);

    }

}
