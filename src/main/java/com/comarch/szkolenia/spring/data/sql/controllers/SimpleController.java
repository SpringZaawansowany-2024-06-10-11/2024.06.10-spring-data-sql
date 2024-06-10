package com.comarch.szkolenia.spring.data.sql.controllers;

import com.comarch.szkolenia.spring.data.sql.dao.ICarDAO;
import com.comarch.szkolenia.spring.data.sql.model.Car;
import com.comarch.szkolenia.spring.data.sql.model.User;
import com.comarch.szkolenia.spring.data.sql.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class SimpleController {

    private final IUserService userService;
    private final ICarDAO carDAO;

    @GetMapping("/test1")
    public void persist() {
        User user1 = new User(0, "Janusz", "Kowalski", 30);
        User user2 = new User(0, "Zbyszek", "Malinowski", 50);
        User user3 = new User(0, "Wiesiek", "Jakis", 10);
        this.userService.persistUser(user1);
        this.userService.persistUser(user2);
        this.userService.persistUser(user3);
    }

    @GetMapping("/test2")
    public List<User> getAll() {
        return this.userService.getAll();
    }

    @GetMapping("/test3/{id}")
    public User getById(@PathVariable("id") int id) {
        Optional<User> userBox = this.userService.getById(id);
        return userBox.orElseGet(() -> new User(0, "default", "default", 0));
    }

    @GetMapping("/test4")
    public void addStuff() {
        this.carDAO.save(new Car(null, "BMW", "u"));
        this.carDAO.save(new Car(null, "Audi", "A5"));
        this.carDAO.save(new Car(null, "Toyota", "Corolla"));
    }

    @GetMapping("/test5")
    public List<Car> getCars() {
        return this.carDAO.findByBrandAndModelPattern("u");
    }

    @GetMapping("/test6")
    public Car getCar() {
        Optional<Car> carBox = this.carDAO.findByBrand("Toyota");
        return carBox.orElseGet(() -> new Car(0L, "default", "default"));
    }
}
