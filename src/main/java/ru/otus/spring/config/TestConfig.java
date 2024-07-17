package ru.otus.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.spring.domain.Answers;
import ru.otus.spring.service.StudentTestingService;
import ru.otus.spring.service.StudentTestingServiceImpl;
@Configuration
public class TestConfig {

    @Value("${myapp.firstQuestion:1}")
    private String firstQuestion;

    @Value("${myapp.secondQuestion:2}")
    private String secondQuestion;

    @Value("${myapp.firstAnswer:Moscow}")
    private String firstAnswer;

    @Value("${myapp.secondAnswer:4}")
    private String secondAnswer;

    @Bean
    public Answers answers() {
        Answers answers = new Answers();
        answers.setFirstQuestion(firstQuestion);
        answers.setSecondQuestion(secondQuestion);
        answers.setFirstAnswer(firstAnswer);
        answers.setSecondAnswer(secondAnswer);
        return answers;
    }


    @Bean
    public StudentTestingService studentTestingService() {
        return new StudentTestingServiceImpl(answers());
    }


}
