package com.ada.proyecto.repository.user;

import com.ada.proyecto.exception.UserNotFoundException;
import com.ada.proyecto.repository.user.User;

import java.util.List;

public interface UsersPersistence {

    void saveUser(User user);

    User getUser(String id) throws UserNotFoundException;

    List<User> getAllUsers();

    void updateUser(String id, User user) throws UserNotFoundException;

    void deleteUser(String id);
}
