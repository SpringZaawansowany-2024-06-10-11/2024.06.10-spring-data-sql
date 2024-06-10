package com.comarch.szkolenia.spring.data.sql.services;

import com.comarch.szkolenia.spring.data.sql.model.User;
import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getAll();
    Optional<User> getById(int id);
    void persistUser(User user);
}
