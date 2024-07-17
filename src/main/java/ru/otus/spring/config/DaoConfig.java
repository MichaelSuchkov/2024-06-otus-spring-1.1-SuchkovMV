package ru.otus.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.spring.dao.PersonDao;
import ru.otus.spring.dao.PersonDaoSimple;
import ru.otus.spring.service.PersonService;
import ru.otus.spring.service.PersonServiceImpl;

@Configuration
public class DaoConfig {
    @Bean
    public PersonDao personDao() {
        return new PersonDaoSimple();
    }

    @Bean
    public PersonService personService() {
        PersonServiceImpl personService = new PersonServiceImpl();
        personService.setDao(personDao());
        return personService;
    }
}
