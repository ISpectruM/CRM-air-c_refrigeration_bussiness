package com.ispectrum.crmclima.areas.home.controllers;

import com.ispectrum.crmclima.areas.BaseController;
import com.ispectrum.crmclima.areas.users.models.dtos.RoleDto;
import com.ispectrum.crmclima.areas.users.models.dtos.UserDto;
import com.ispectrum.crmclima.areas.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.awt.font.TextHitInfo;
import java.security.Principal;

@Controller
public class HomeController extends BaseController {
    private final UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ModelAndView homePage(Principal principal){
        UserDto userByName = this.userService.findUserByName(principal.getName());
        boolean role_installer = userByName.getAuthorities()
                .stream().anyMatch(roleDto -> roleDto.getAuthority().equals("ROLE_INSTALLER"));
        if (role_installer){
            return this.redirect("/schedule/all");
        }
        return this.redirect("/clients/all?page=0");
    }
}
