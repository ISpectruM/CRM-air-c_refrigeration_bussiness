package com.ispectrum.crmclima.areas.users.models.dtos;


import java.util.ArrayList;
import java.util.List;

public class UserDto {
    private String id;
    private String username;
    private String password;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;
    private List<RoleDto> authorities;

    public UserDto() {
        this.authorities = new ArrayList<>();
    }

    public boolean isAdmin(){
        return this.getAuthorities()
                .stream()
                .anyMatch(role -> role.getAuthority()
                        .equals("ROLE_ADMIN"));
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAccountNonExpired() {
        return this.isAccountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return this.isAccountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return this.isCredentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public List<RoleDto> getAuthorities() {
        return this.authorities;
    }

    public void setAuthorities(List<RoleDto> authorities) {
        this.authorities = authorities;
    }
}
