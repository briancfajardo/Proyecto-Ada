package com.ada.proyecto.service.user;

import com.ada.proyecto.exception.UserNotFoundException;
import com.ada.proyecto.repository.user.User;
import com.ada.proyecto.repository.user.UserRepositoryMongoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class UserServiceMongoDB implements UsersService{

    private final UserRepositoryMongoDB userRepositoryMongoDB;

    public UserServiceMongoDB(@Autowired UserRepositoryMongoDB userRepositoryMongoDB) {
        this.userRepositoryMongoDB = userRepositoryMongoDB;
    }

    @Override
    public User save(User user) {
        return userRepositoryMongoDB.save(user);
    }

    @Override
    public Optional<User> findById(String id) {
        Optional<User> user = userRepositoryMongoDB.findById(id);
        if (!user.isPresent())
            throw new UserNotFoundException(id);
        return user;
    }

    @Override
    public User update(User user, String userId) {
        Optional<User> userToUpdate = userRepositoryMongoDB.findById(userId);
        if (!userToUpdate.isPresent())
            throw new UserNotFoundException(userId);
        return userRepositoryMongoDB.save(user);
    }

    @Override
    public void deleteById(String id) {
        userRepositoryMongoDB.deleteById(id);
    }

    @Override
    public List<User> all() {
        return userRepositoryMongoDB.findAll();
    }
}
