package com.ada.proyecto.controller.user;

import com.ada.proyecto.exception.UserNotFoundException;
import com.ada.proyecto.repository.user.User;
import com.ada.proyecto.repository.user.UserDto;
import com.ada.proyecto.service.user.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/users/")
public class UsersController {

    private final UsersService usersService;

    public UsersController(@Autowired UsersService usersService) {

        this.usersService = usersService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {
        User user = new User(userDto);
        User savedUser = usersService.save(user);
        URI createdUserUri = URI.create("/v1/users/" + savedUser.getId());
        System.out.println(savedUser);
        return ResponseEntity.created(createdUserUri).body(savedUser);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = usersService.all();
        for(User user : users){
            System.out.println(user);
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> findById(@PathVariable("id") String id) {
        Optional<User> userOptional = usersService.findById(id);
        if (userOptional.isPresent()) {
            System.out.println(userOptional);
            return ResponseEntity.ok(userOptional.get());
        } else {
            throw new UserNotFoundException(id);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") String id, @RequestBody UserDto userDto) {
        Optional<User> userOptional = usersService.findById(id);
        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();
            existingUser.update(userDto);
            User updatedUser = usersService.save(existingUser);
            System.out.println(updatedUser);
            return ResponseEntity.ok(updatedUser);
        } else {
            throw new UserNotFoundException(id);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") String id) {
        Optional<User> userOptional = usersService.findById(id);
        if (userOptional.isPresent()) {
            System.out.println("User deleted: "+userOptional);
            usersService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            throw new UserNotFoundException(id);
        }
    }
}
