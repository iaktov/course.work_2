package com.example.course.work_2.Service;

import com.example.course.work_2.Interface.QuestionService;
import com.example.course.work_2.Model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService {

    //    Set<Question> questions;
    Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        System.out.println(newQuestion);
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        return null;
    }

    @Override
    public Question remove(Question question) {
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return null;
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        random.nextInt(256);
        return null;
    }
}
