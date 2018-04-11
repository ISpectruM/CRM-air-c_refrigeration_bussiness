package com.ispectrum.crmclima.areas.users.service;

import com.ispectrum.crmclima.areas.users.entities.User;
import com.ispectrum.crmclima.areas.users.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findUserByUsername(username);

    }

    @Override
    public void addUser(User user) {
        this.userRepository.saveAndFlush(user);
    }
}
