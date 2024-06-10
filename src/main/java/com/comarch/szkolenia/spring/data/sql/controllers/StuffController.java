package com.comarch.szkolenia.spring.data.sql.controllers;

import com.comarch.szkolenia.spring.data.sql.dao.ICustomStuffRepository;
import com.comarch.szkolenia.spring.data.sql.dao.IStuffRepository;
import com.comarch.szkolenia.spring.data.sql.model.Stuff;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/stuff")
public class StuffController {

    private final IStuffRepository stuffRepository;
    private final ICustomStuffRepository customStuffRepository;

    @GetMapping("/test1")
    public void addStuff() {
        Stuff stuff1 = new Stuff(null, "PC", 2);
        Stuff stuff2 = new Stuff(null, "Car", 1);
        Stuff stuff3 = new Stuff(null, "Dog", 3);
        Stuff stuff4 = new Stuff(null, "Cat", 5);
        Stuff stuff5 = new Stuff(null, "Room", 6);

        this.stuffRepository.insert(stuff1);
        this.stuffRepository.insert(stuff2);
        this.stuffRepository.insert(stuff3);
        this.stuffRepository.insert(stuff4);
        this.stuffRepository.insert(stuff5);
    }

    @GetMapping("/test2")
    public List<Stuff> getStuff() {
        return this.stuffRepository.findAll();
    }

    @GetMapping("/test3")
    public Stuff getById() {
        Optional<Stuff> staffBox = this.stuffRepository.findById("sadfgsdf");
        return staffBox.orElseGet(Stuff::new);
    }

    @GetMapping("/test4")
    public void update() {
        this.customStuffRepository.updateQuantityByName("PC", 1);
    }

    @GetMapping("/test5")
    public Stuff get() {
        Optional<Stuff> stuffBox = this.stuffRepository.findByName("PC");
        return stuffBox.orElseGet(Stuff::new);
    }
}
