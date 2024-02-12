package com.ada.proyecto.repository.user;

public class UserDto {
    private final String id;
    private final String name;
    private final String lastName;
    private final String email;
    private final String password;

    public UserDto() {
        this.id = "";
        this.name = "";
        this.lastName = "";
        this.email = "";
        this.password = "";
    }

    public UserDto(String name, String lastName, String email, String password) {
        this.id = "";
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public UserDto(String id, String name, String lastName, String email, String password) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public UserDto(String name, String lastName, String email) {
        this.id = "";
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = "";
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
