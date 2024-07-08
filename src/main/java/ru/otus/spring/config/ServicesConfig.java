package ru.otus.spring.config;

import org.springframework.context.annotation.Bean;
import ru.otus.spring.dao.PersonDao;
import ru.otus.spring.dao.PersonDaoSimple;
import ru.otus.spring.service.PersonService;
import ru.otus.spring.service.PersonServiceImpl;

public class ServicesConfig {
    @Bean
    public PersonService personService() {
        PersonServiceImpl personService = new PersonServiceImpl();
        personService.setDao(personDao());
        return personService;
    }

    @Bean
    public PersonDao personDao() {
        return new PersonDaoSimple();
    }
}
