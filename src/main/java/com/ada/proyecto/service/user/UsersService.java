package com.ada.proyecto.service.user;

import com.ada.proyecto.repository.user.User;

import java.util.List;
import java.util.Optional;

public interface UsersService {

    User save(User user);

    Optional<User> findById(String id);

    User update(User user, String userId);

    void deleteById(String id);

    List<User> all();

}
