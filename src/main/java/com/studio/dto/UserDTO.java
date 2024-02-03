package com.studio.dto;

import com.studio.common.UserRole;

public class UserDTO {
    private long id;
    private String name;
    private String email;
    private String password;
    private UserRole userRole;

    public UserDTO() {

    }

    public UserDTO(final long id, final String name, final String email, final String password, final UserRole userRole) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }

    public UserDTO(final String name, final String email, final String password, final UserRole userRole) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }


}
