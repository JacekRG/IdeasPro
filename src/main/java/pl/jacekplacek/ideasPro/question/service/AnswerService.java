package pl.jacekplacek.ideasPro.question.service;


import org.springframework.stereotype.Service;
import pl.jacekplacek.ideasPro.question.domain.model.Answer;

import java.util.*;

@Service
public class AnswerService {
    public List<Answer> getAnswers(UUID questionId) {
        return Arrays.asList(
                new Answer("Answer 1"),
                new Answer("Answer 2"),
                new Answer("Answer 3")
        );
    }

    public Answer getAnswer(UUID id) {
        return new Answer("Answer " + id);
    }

    public Answer createAnswer(UUID questionId, Answer answer) {
        return null;
    }

    public Answer updateAnswer(UUID answerId, Answer answer) {
        return null;
    }

    public void deleteAnswer(UUID answerId) {
    }
}
