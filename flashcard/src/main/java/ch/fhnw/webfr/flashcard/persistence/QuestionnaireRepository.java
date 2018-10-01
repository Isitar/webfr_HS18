package ch.fhnw.webfr.flashcard.persistence;

import java.util.ArrayList;
import java.util.List;

import ch.fhnw.webfr.flashcard.domain.Questionnaire;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public interface QuestionnaireRepository extends MongoRepository<Questionnaire, String> {
    List<Questionnaire> findByTitle(String title);
}