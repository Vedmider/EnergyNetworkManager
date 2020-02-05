package com.persitence.repository;

import com.persitence.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {
    Optional<User> findUserByLoginAndPassword(String login, String password);
    Optional<User> findByLogin(String login);
    List<User> getAll();
}
