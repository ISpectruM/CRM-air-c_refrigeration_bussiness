package com.ispectrum.crmclima.areas.home.controllers;

import com.ispectrum.crmclima.areas.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public class HomeController extends BaseController {

    @GetMapping("/")
    public ModelAndView homePage(){

        return this.view("home/home");
    }
}
