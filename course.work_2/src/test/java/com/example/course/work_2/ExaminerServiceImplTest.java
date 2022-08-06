package com.example.course.work_2;

import com.example.course.work_2.Exceptions.NumberOfRequestException;
import com.example.course.work_2.Model.Question;
import com.example.course.work_2.Service.ExaminerServiceImpl;
import com.example.course.work_2.Service.JavaQuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    public void getRandomQuestionTest() {
        List<Question> questions = new ArrayList<>(List.of(
                new Question("first question","first answer"),
                new Question("second question","second answer"),
                new Question("first question","second answer")
        ));

        when(javaQuestionService.getAll()).thenReturn(questions);
        when(javaQuestionService.getRandomQuestion())
                .thenReturn(questions.get(0), questions.get(1), questions.get(1), questions.get(2));
        assertThat(examinerService.getQuestion(3)).containsExactlyInAnyOrder(questions.get(0), questions.get(1),questions.get(2));
    }

    @Test
    public void getRandomQuestionNegativeTest() {
        //amount < 0
        assertThatExceptionOfType(NumberOfRequestException.class)
                .isThrownBy(() -> examinerService.getQuestion(-10));
        // amount > кол-ва вопросов(так как размер не задавали, по умолчанию 0)
        assertThatExceptionOfType(NumberOfRequestException.class)
                .isThrownBy(() -> examinerService.getQuestion(5));


    }






}
