package com.ispectrum.crmclima.areas.users.controllers;

import com.ispectrum.crmclima.areas.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController{

    @GetMapping("/add")
    public ModelAndView addUser(){
        return this.view("add");
    }

    @PostMapping("/add")
    public ModelAndView addUserAction(){
        return this.redirect("/all");
    }

    @GetMapping("/all")
    public ModelAndView allUsers(){
        return this.view("all");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editUser(@PathVariable String id){
        return this.view("edit");
    }

    @PostMapping("/edit/{id}")
    public ModelAndView editUserAction(@PathVariable @Valid String id){
        return this.redirect("all");
    }
}
