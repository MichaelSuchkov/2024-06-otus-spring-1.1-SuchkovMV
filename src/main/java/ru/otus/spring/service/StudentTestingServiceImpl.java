package ru.otus.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.spring.domain.Answers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class StudentTestingServiceImpl implements StudentTestingService {

    private Answers answers;

    @Autowired
    public StudentTestingServiceImpl(Answers answers) {
        this.answers = answers;
    }
    public HashMap truAnswers() {
        HashMap<String, String> mapTruAnswers = new HashMap<>();
        mapTruAnswers.put(answers.getFirstQuestion(), answers.getFirstAnswer());
        mapTruAnswers.put(answers.getSecondQuestion(), answers.getSecondAnswer());
        return mapTruAnswers;

    }

    @Override
    public HashMap openFile(String name) {
        String filePath = "C:/Users/User-PC/Desktop/" + name + ".txt";
        HashMap<String, String> questionsAndAnswers = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 2);

                if (parts.length == 2) {
                    String question = parts[0].trim();
                    String answer = parts[1].trim();

                    questionsAndAnswers.put(question, answer);

                }
            }
            br.close();
            return questionsAndAnswers;
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
        HashMap<String, String> map = new HashMap<>();
        return map;
    }

    @Override
    public String testStudent(String name) {
        // Получаем правильные ответы
        Map<String, String> truAnswers = truAnswers();

        // Получаем вопросы и ответы студента
        Map<String, String> questionsAndAnswers = openFile(name);

        StringBuilder result = new StringBuilder("\n");

        // Проходим по всем вопросам и ответам студента
        for (Map.Entry<String, String> entry : questionsAndAnswers.entrySet()) {
            String question = entry.getKey();
            String studentAnswer = entry.getValue();
            String correctAnswer = truAnswers.get(question);

            // Формируем результат
            result.append("Question: ").append(question).append("\n");
            result.append(name + " Answer: ").append(studentAnswer).append("\n");

            if (studentAnswer.equals(correctAnswer)) {
                result.append("Correct Answer!\n\n");
            } else {
                result.append("Incorrect! Correct Answer: ").append(correctAnswer).append("\n\n");
            }
        }

        return result.toString();
    }
}
