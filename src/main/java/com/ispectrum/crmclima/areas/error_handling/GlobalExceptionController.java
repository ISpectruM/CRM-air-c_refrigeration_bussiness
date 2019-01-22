package com.ispectrum.crmclima.areas.error_handling;

import com.ispectrum.crmclima.areas.BaseController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionController extends BaseController {

    @ExceptionHandler(RuntimeException.class)
    public ModelAndView getRuntimeException(RuntimeException e){

        String errorMessage =
                e.getClass().isAnnotationPresent(ResponseStatus.class) ?
                        e.getClass().getAnnotation(ResponseStatus.class).reason() :
                        e.getMessage();
        return this.addViewAndObject("exception", errorMessage,"error/error_page");
    }
}
