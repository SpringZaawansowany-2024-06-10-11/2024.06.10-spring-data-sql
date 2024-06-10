package com.comarch.szkolenia.spring.data.sql.dao;

import com.comarch.szkolenia.spring.data.sql.model.Car;
import com.comarch.szkolenia.spring.data.sql.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IUserDAO extends CrudRepository<User, Integer> {
}
