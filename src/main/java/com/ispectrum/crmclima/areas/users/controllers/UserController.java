package com.ispectrum.crmclima.areas.users.controllers;

import com.ispectrum.crmclima.areas.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController{

    @GetMapping("/login")
    public ModelAndView login(@RequestParam(required = false)String error){

        if (error != null){
            return this.addViewAndObject("error", error,"users/login");
        }
        return this.setView("users/login");
    }

}
