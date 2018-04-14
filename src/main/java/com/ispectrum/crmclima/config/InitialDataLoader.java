package com.ispectrum.crmclima.config;

import com.ispectrum.crmclima.areas.users.entities.Role;
import com.ispectrum.crmclima.areas.users.entities.User;
import com.ispectrum.crmclima.areas.users.repository.RoleRepository;
import com.ispectrum.crmclima.areas.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent>{
    private boolean alreadySetup = false;

    private final RoleRepository roleRepository;

    private final UserService userService;

    private final BCryptPasswordEncoder encoder;

    @Autowired
    public InitialDataLoader(RoleRepository roleRepository,
                             UserService userService, BCryptPasswordEncoder encoder) {
        this.roleRepository = roleRepository;
        this.userService = userService;
        this.encoder = encoder;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (alreadySetup) return;

        this.createRoleIfNotFound("ROLE_ADMIN");
        this.createRoleIfNotFound("ROLE_SELLER");
        this.createRoleIfNotFound("ROLE_INSTALLER");

        User admin = createAdminIfNotFound();

        this.createAdminIfNotFound();
        this.userService.persistUser(admin);

        alreadySetup = true;
    }

    private User createAdminIfNotFound() {
        Role adminRole = this.roleRepository.findFirstByAuthority("ROLE_ADMIN");
        User admin = (User)this.userService.loadUserByUsername("admin");

        if (admin == null){
            admin = new User();
            admin.setAuthorities(Set.of(adminRole));
            admin.setAccountNonExpired(true);
            admin.setAccountNonLocked(true);
            admin.setCredentialsNonExpired(true);
            admin.setEnabled(true);
            admin.setUsername("admin");
            admin.setPassword(this.encoder.encode("123"));
        }
        return admin;
    }

    @Transactional
    Role createRoleIfNotFound(String name) {

        Role role = this.roleRepository.findFirstByAuthority(name);
        if (role == null) {
            role = new Role();
            role.setAuthority(name);
            this.roleRepository.save(role);
        }

        return role;
    }
}
