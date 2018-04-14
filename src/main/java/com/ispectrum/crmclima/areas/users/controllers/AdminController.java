package com.ispectrum.crmclima.areas.users.controllers;

import com.ispectrum.crmclima.areas.BaseController;
import com.ispectrum.crmclima.areas.users.entities.User;
import com.ispectrum.crmclima.areas.users.models.bindingModels.AddUserBindingModel;
import com.ispectrum.crmclima.areas.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController{

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/add")
    public ModelAndView addUser(){
        return this.view("admin/add");
    }

    @PostMapping("/add")
    public ModelAndView addUserAction(AddUserBindingModel model){
        this.userService.addUser(model);
        return this.redirect("/admin/all");
    }

    @GetMapping("/all")
    public ModelAndView allUsers(){
        Set<User> users = this.userService.getAllUsers();
        return this.addViewObject("users", users,"admin/all");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editUser(@PathVariable String id){
        return this.view("edit");
    }

    @PostMapping("/edit/{id}")
    public ModelAndView editUserAction(@PathVariable @Valid String id){
        return this.redirect("all");
    }

    @GetMapping("/unauthorized")
    public ModelAndView unauthorized(){
        return this.view( "users/unauthorized");
    }


}
