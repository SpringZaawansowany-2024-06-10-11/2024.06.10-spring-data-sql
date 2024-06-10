package com.comarch.szkolenia.spring.data.sql.dao;

import com.comarch.szkolenia.spring.data.sql.model.Stuff;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IStuffRepository extends MongoRepository<Stuff, String> {
    Optional<Stuff> findByName(String name);
}
