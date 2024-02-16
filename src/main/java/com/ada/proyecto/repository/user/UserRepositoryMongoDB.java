package com.ada.proyecto.repository.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryMongoDB extends MongoRepository<User, String> {

}
