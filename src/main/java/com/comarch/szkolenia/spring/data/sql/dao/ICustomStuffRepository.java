package com.comarch.szkolenia.spring.data.sql.dao;

public interface ICustomStuffRepository {
    void updateQuantityByName(String name, int quantity);
}
