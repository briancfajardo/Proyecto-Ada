package com.ada.proyecto.repository.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.processing.Generated;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;


@Document("users")
public class User {
    @Id
    private String id;
    @Field
    private LocalDate createdAt;
    @Field
    private String name;
    @Field
    private String lastName;
    @Field
    private String email;
    @Field
    private String passwordHash;

    public User(){

    }

    public User(String id, String name, String lastName, String email, String password) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.passwordHash = new BCryptPasswordEncoder().encode(password);
        this.createdAt = LocalDate.now();
    }

    public User(UserDto userDto) {
        this.id = UUID.randomUUID().toString();
        this.name = userDto.getName();
        this.lastName = userDto.getLastName();
        this.email = userDto.getEmail();
        this.passwordHash = new BCryptPasswordEncoder().encode(userDto.getPassword());
        this.createdAt = LocalDate.now();
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void update(UserDto userDto) {
        this.name = userDto.getName();
        this.lastName = userDto.getLastName();
        this.email = userDto.getEmail();
        if (!userDto.getPassword().isEmpty()) {
            this.passwordHash = new BCryptPasswordEncoder().encode(userDto.getPassword());
        }
    }
    @Override
    public String toString(){
        return String.format("User[id='%s', firstName='%s', lastName='%s', email='%s', password='%s']", id, name, lastName, email, passwordHash);
    }
}
