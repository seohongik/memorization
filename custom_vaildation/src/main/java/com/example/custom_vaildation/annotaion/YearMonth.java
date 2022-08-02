package com.example.custom_vaildation.annotaion;

import com.example.custom_vaildation.validator.YearMonthValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.AssertTrue;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = {YearMonthValidator.class})
public @interface YearMonth {

    String message() default "{yyyyMM의 형식에 맞지 않습니다.}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    String pattern() default "yyyyMM";

}
