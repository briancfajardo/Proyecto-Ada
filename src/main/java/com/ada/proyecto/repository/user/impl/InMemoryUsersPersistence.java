package com.ada.proyecto.repository.user.impl;

import com.ada.proyecto.exception.UserNotFoundException;
import com.ada.proyecto.repository.user.UsersPersistence;
import com.ada.proyecto.repository.user.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InMemoryUsersPersistence implements UsersPersistence {

    private Map<String,User> users = new HashMap<>();


    @Override
    public void saveUser(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public User getUser(String id) throws UserNotFoundException {
        return users.get(id);
    }

    @Override
    public List<User> getAllUsers() {
        return  new ArrayList<>(users.values());
    }

    @Override
    public void updateUser(String id, User user) throws UserNotFoundException {
        users.put(id, user);
    }

    @Override
    public void deleteUser(String id) {
        users.remove(id);
    }
}
