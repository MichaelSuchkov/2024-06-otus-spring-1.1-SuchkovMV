package ru.otus.spring.dao;

import ru.otus.spring.domain.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDaoSimple implements PersonDao{
    private final List<Person> persons = new ArrayList<>();
    private final List<Object> cash = new ArrayList<>();

    @Override
    public Person findByName(String name) {
        for (Object obj : cash) {
            if (obj instanceof Person) {
                Person person = (Person) obj;
                if (person.getName().equals(name)) {
                    return person;
                }
            }
        }
        return null;
    }

    @Override
    public void save(Person person) {
        persons.add(person);
        cash.addAll(persons);
    }

    @Override
    public List<Person> findAll() {
        return new ArrayList<>(persons);
    }
}
