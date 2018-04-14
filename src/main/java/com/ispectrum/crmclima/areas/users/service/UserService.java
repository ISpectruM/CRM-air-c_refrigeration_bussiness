package com.ispectrum.crmclima.areas.users.service;

import com.ispectrum.crmclima.areas.users.entities.User;
import com.ispectrum.crmclima.areas.users.models.bindingModels.AddUserBindingModel;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Set;


public interface UserService extends UserDetailsService{

    void addUser(AddUserBindingModel addUserBindingModel);

    void persistUser(User user);

    Set<User> getAllUsers();
}
