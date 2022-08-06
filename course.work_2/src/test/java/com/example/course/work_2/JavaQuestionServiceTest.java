package com.example.course.work_2;


import com.example.course.work_2.Exceptions.NoDataDeleteException;
import com.example.course.work_2.Exceptions.NoDataEnteredException;
import com.example.course.work_2.Interface.QuestionService;
import com.example.course.work_2.Model.Question;
import com.example.course.work_2.Service.JavaQuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class JavaQuestionServiceTest {
    private final QuestionService actual = new JavaQuestionService();
    Question emptyQuestion = new Question("", "");

    Question wrongQuestion = new Question("one", "two");

    @Test
    public void ExceptionQuestionTest() {
        //Добавление пустого объекта
        assertThatExceptionOfType(NoDataEnteredException.class)
                .isThrownBy(() -> actual.add(emptyQuestion));
        //Удаление пустого объекта
        assertThatExceptionOfType(NoDataEnteredException.class)
                .isThrownBy(() -> actual.remove(emptyQuestion));
        //Добавление объекта с пользовательскими пустыми параметрами
        assertThatExceptionOfType(NoDataEnteredException.class)
                .isThrownBy(() -> actual.add("", ""));
        //Удаление объекта, которого нет во множестве
        assertThatExceptionOfType(NoDataDeleteException.class)
                .isThrownBy(() -> actual.remove(wrongQuestion));
    }


    @ParameterizedTest
    @MethodSource("questionForAdd")
    public void addQuestionTest(String question, String answer) {

        Question expected = new Question(question, answer);
        actual.add(question, answer);
        assertThat(actual.add(question, answer)).isEqualTo(expected);
        assertThat(actual.getAll()).containsExactlyInAnyOrder(expected);

    }

    @ParameterizedTest
    @MethodSource("questionForRemove")
    public void removeQuestionTest(String question, String answer) {

        Question expected = new Question(question, answer);
        Question removableQuestion = new Question("First question", "Second answer");
        actual.add(removableQuestion);
        assertThat(actual.remove(removableQuestion)).isEqualTo(expected);

    }

    @ParameterizedTest
    @MethodSource("questions")
    public void getRandomQuestionTest(Set<Question> questions) {
        questions.forEach(actual::add);
        assertThat(actual.getAll()).hasSize(questions.size());
        assertThat(actual.getRandomQuestion()).isIn(actual.getAll());
    }


    public static Stream<Arguments> questionForAdd() {
        return Stream.of(
                Arguments.of("First question", "First answer")
        );
    }

    public static Stream<Arguments> questionForRemove() {
        return Stream.of(
                Arguments.of("First question", "Second answer")
        );
    }

    public static Stream<Arguments> questions() {
        return Stream.of(
                Arguments.of(Set.of(
                        new Question("First question", "First answer"),
                        new Question("Second question", "Second answer"),
                        new Question("First question", "Second answer")
                )));
    }


}
