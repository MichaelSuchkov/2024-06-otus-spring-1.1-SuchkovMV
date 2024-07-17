package ru.otus.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.otus.spring.config.DaoConfig;
import ru.otus.spring.config.TestConfig;
import ru.otus.spring.domain.Person;
import ru.otus.spring.service.PersonService;
import ru.otus.spring.service.StudentTestingService;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DaoConfig.class, TestConfig.class);
        PersonService service = context.getBean(PersonService.class);

        StudentTestingService studentTestingService = context.getBean(StudentTestingService.class);


        service.save(new Person("Ivan", 18));
        service.save(new Person("Anna", 22));



        Person person = service.getByName("Ivan");
        System.out.println("name: " + person.getName() + " age: " + person.getAge() + " rezult: " + studentTestingService.testStudent(person.getName()));

        context.close();
    }
}
