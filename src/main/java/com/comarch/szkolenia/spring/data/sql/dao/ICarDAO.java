package com.comarch.szkolenia.spring.data.sql.dao;

import com.comarch.szkolenia.spring.data.sql.model.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ICarDAO extends CrudRepository<Car, Long> {
    List<Car> findByBrandAndModel(String brand, String model);
    @Query(value = "select c from com.comarch.szkolenia.spring.data.sql.model.Car c where c.brand like %:pattern% OR c.model like %:pattern%")
    List<Car> findByBrandAndModelPattern(@Param("pattern") String pattern);
    @Query(value = "select * from tcar where brand = :brand", nativeQuery = true)
    Optional<Car> findByBrand(@Param("brand") String brand);
}
