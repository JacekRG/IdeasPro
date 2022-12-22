package pl.jacekplacek.ideasPro.question.service;

import org.springframework.stereotype.Component;
import pl.jacekplacek.ideasPro.question.domain.model.Question;
import pl.jacekplacek.ideasPro.question.dto.QuestionDto;

@Component
public class QuestionMapper {

    public QuestionDto map(Question question) {
        QuestionDto questionDto = new QuestionDto();
        questionDto.setId(question.getId());
        questionDto.setName(question.getName());
        questionDto.setCategoryId(question.getCategory().getId());
        questionDto.setCategoryName(question.getCategory().getName());
        questionDto.setAnswers(question.getAnswers() == null ? 0 : question.getAnswers().size());
        questionDto.setCreated(question.getCreated());

        return questionDto;
    }
}
