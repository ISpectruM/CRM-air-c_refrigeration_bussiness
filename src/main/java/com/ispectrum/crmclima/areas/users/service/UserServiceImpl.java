package com.ispectrum.crmclima.areas.users.service;

import com.ispectrum.crmclima.Utils.ModelMappingUtil;
import com.ispectrum.crmclima.areas.users.entities.Role;
import com.ispectrum.crmclima.areas.users.entities.User;
import com.ispectrum.crmclima.areas.users.models.bindingModels.AddUserBindingModel;
import com.ispectrum.crmclima.areas.users.models.bindingModels.EditUserBindingModel;
import com.ispectrum.crmclima.areas.users.models.dtos.UserDto;
import com.ispectrum.crmclima.areas.users.repository.RoleRepository;
import com.ispectrum.crmclima.areas.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder,
                           RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findUserByUsername(username);
    }

    @Override
    public void addUser(AddUserBindingModel model) {
        User user = createUser(model);

        Role role = this.roleRepository.findFirstByAuthority(model.getRole());
        List<Role> authorities = new ArrayList<>();
        authorities.add(role);
        user.setAuthorities(authorities);

        this.persistUser(user);
    }

    @Override
    public Set<UserDto> getAllUsers() {
        Set<User> allUsers = this.userRepository.findAllBy();
        return ModelMappingUtil.convertSet(allUsers,UserDto.class);
    }

    @Override
    public UserDto getUserById(String userId) {
        User user = this.userRepository.findUserById(userId);
        return ModelMappingUtil.convertClass(user,UserDto.class);
    }

    @Override
    public void editUser(String id, EditUserBindingModel editModel) {
        User user = ModelMappingUtil.convertClass(editModel, User.class);

        String password = this.bCryptPasswordEncoder.encode(editModel.getPassword());
        user.setPassword(password);

        List<Role> authorities = new ArrayList<>();
        authorities.add(this.roleRepository.findFirstByAuthority(editModel.getRole()));
        user.setAuthorities(authorities);

        this.userRepository.saveAndFlush(user);
    }

    private User createUser(AddUserBindingModel model) {
        String password = model.getPassword();
        String encodedPassword = this.bCryptPasswordEncoder.encode(password);

        User user = new User();
        user.setUsername(model.getUsername());
        user.setPassword(encodedPassword);
        user.setAccountNonExpired(model.isAccountNonExpired());
        user.setAccountNonLocked(model.isAccountNonLocked());
        user.setCredentialsNonExpired(model.isCredentialsNonExpired());
        user.setEnabled(model.isEnabled());
        return user;
    }

    @Override
    public void persistUser(User user) {
        this.userRepository.saveAndFlush(user);
    }

    @Override
    public void deleteUser(String userId) {
        User user = this.userRepository.findUserById(userId);
        this.userRepository.delete(user);
    }


}
