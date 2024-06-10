package com.comarch.szkolenia.spring.data.sql.services;

import com.comarch.szkolenia.spring.data.sql.dao.IUserDAO;
import com.comarch.szkolenia.spring.data.sql.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final IUserDAO userDAO;

    @Override
    public List<User> getAll() {
        final List<User> result = new ArrayList<>();
        this.userDAO.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Optional<User> getById(int id) {
        return this.userDAO.findById(id);
    }

    @Override
    public void persistUser(User user) {
        this.userDAO.save(user);
    }
}
