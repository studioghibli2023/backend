package com.studio.dto;

public class CustomerDTO {
    private long id;
    private String name;
    private String email;

    public CustomerDTO() {

    }

    public CustomerDTO(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public CustomerDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
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

}
