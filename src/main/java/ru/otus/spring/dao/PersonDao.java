package ru.otus.spring.dao;

import ru.otus.spring.domain.Person;

import java.util.List;

public interface PersonDao {
    Person findByName(String name);
    void save(Person person);
    List<Person> findAll();
}
