package pl.jacekplacek.ideasPro.question.domain.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jacekplacek.ideasPro.question.domain.model.Question;

import java.util.UUID;

@Repository
public interface AnswerRepository extends JpaRepository <Question, UUID>{



}
