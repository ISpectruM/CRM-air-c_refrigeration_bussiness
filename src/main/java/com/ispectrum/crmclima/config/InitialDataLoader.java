package com.ispectrum.crmclima.config;

import com.ispectrum.crmclima.areas.users.entities.Role;
import com.ispectrum.crmclima.areas.users.entities.User;
import com.ispectrum.crmclima.areas.users.repository.RoleRepository;
import com.ispectrum.crmclima.areas.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent>{
    boolean alreadySetup = false;

    private final RoleRepository roleRepository;

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder encoder;

    @Autowired
    public InitialDataLoader(RoleRepository roleRepository, UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (alreadySetup) return;

        createRoleIfNotFound("ROLE_ADMIN");
        createRoleIfNotFound("ROLE_USER");
        createRoleIfNotFound("ROLE_INSTALLER");

        Role adminRole = this.roleRepository.findByAuthority("ROLE_ADMIN");
        User admin = new User();
        admin.setAuthorities(Set.of(adminRole));
        admin.setAccountNonExpired(true);
        admin.setAccountNonLocked(true);
        admin.setCredentialsNonExpired(true);
        admin.setEnabled(true);
        admin.setUsername("admin");
        admin.setPassword(this.encoder.encode("123"));

        this.userRepository.saveAndFlush(admin);

        alreadySetup = true;
    }

    @Transactional
    Role createRoleIfNotFound(String name) {

        Role role = this.roleRepository.findByAuthority(name);
        if (role == null) {
            role = new Role();
            role.setAuthority(name);
            this.roleRepository.save(role);
        }

        return role;
    }
}
