package com.comarch.szkolenia.spring.data.sql.dao;


import com.comarch.szkolenia.spring.data.sql.model.Stuff;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CustomStuffRepository implements ICustomStuffRepository {

    private final MongoTemplate mongoTemplate;
    @Override
    public void updateQuantityByName(String name, int quantity) {
        Query query = new Query(Criteria.where("name").is(name));
        Update update = new Update().set("quantity", quantity);
        this.mongoTemplate.updateFirst(query, update, Stuff.class);
    }
}
