package com.micro.services.exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class Exceptionhandler{

    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public int methodArgumentTypeMismatchException(Model model)
    {
    model.addAttribute("msg","At end of URL please provide valid ID");

        System.out.println("At end of URL please provide valid ID");
        return 1;
    }
    @ExceptionHandler(value = NullPointerException.class)
    public String nullPointerException(Model model)
    { model.addAttribute("msg1","At end of URL please provide valid ID");
        System.out.println("At end of URL please provide valid ID");
        return "error1";
    }

}
