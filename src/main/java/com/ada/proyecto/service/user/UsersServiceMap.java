package com.ada.proyecto.service.user;

import com.ada.proyecto.repository.user.UsersPersistence;
import com.ada.proyecto.repository.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceMap implements UsersService {

    @Autowired
    UsersPersistence users=null;


    @Override
    public User save(User user) {
        users.saveUser(user);
        return user;
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(users.getUser(id));
    }

    @Override
    public List<User> all() {
        return users.getAllUsers();
    }

    @Override
    public void deleteById(String id) {
        users.deleteUser(id);
    }

    @Override
    public User update(User user, String userId) {
        users.updateUser(userId,user);
        return user;
    }
}

