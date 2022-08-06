package com.example.course.work_2.Service;

import com.example.course.work_2.Exceptions.NoDataEnteredException;
import com.example.course.work_2.Exceptions.NoDataDeleteException;
import com.example.course.work_2.Interface.QuestionService;
import com.example.course.work_2.Model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions;
    private final Random random;


    public JavaQuestionService() {
        this.questions = new HashSet<>();
        this.random = new Random();
    }

    @Override
    public Question add(String question, String answer) {
        if (question.equals(null) || answer.equals(null)) {
            throw new NullPointerException();
        }
            if (question.equals("") || answer.equals("")) {
            throw new NoDataEnteredException();
        }
        Question newQuestion = new Question(question, answer);
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        if (question.equals(null)) {
            throw new NullPointerException();
        }
        if (question.getQuestion().equals("") || question.getAnswer().equals("")) {
            throw new NoDataEnteredException();
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (question.equals(null)) {
            throw new NullPointerException();
        }
        if (question.getQuestion().equals("") || question.getAnswer().equals("")) {
            throw new NoDataEnteredException();
        }
        if (!questions.contains(question)) {
            throw new NoDataDeleteException();
        } else {
            questions.remove(question);
            return question;
        }
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        return new ArrayList<>(questions).get(random.nextInt(questions.size()));
    }
}
