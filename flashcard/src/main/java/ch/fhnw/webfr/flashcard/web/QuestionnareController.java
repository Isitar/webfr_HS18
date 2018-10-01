package ch.fhnw.webfr.flashcard.web;

import ch.fhnw.webfr.flashcard.domain.Questionnaire;
import ch.fhnw.webfr.flashcard.persistence.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/questionaire")
public class QuestionnareController {

    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    @GetMapping()
    public void findAll(HttpServletResponse response, HttpServletRequest request) throws IOException {
        List<Questionnaire> questionnaires = questionnaireRepository.findAll();
        PrintWriter writer = response.getWriter();
        writer.append("<html><head><title>Example</title></head><body>");
        writer.append("<h3>Fragebögen</h3>");
        for (Questionnaire questionnaire : questionnaires) {
            String url = request.getContextPath() + request.getServletPath();
            url = url + "/" + questionnaire.getId().toString();
            writer.append("<p><a href='" + response.encodeURL(url) + "'>" + questionnaire.getTitle() + "</a></p>");
        }
        writer.append("</body></html>");
    }

    @GetMapping("/{id}")
    public void findById(@PathVariable String id, HttpServletResponse response, HttpServletRequest request) throws IOException {
        Questionnaire questionnaires = questionnaireRepository.findById(id).get();
        PrintWriter writer = response.getWriter();
        writer.append("<html><head><title>Example</title></head><body>");
        writer.append("<h3>Fragebogen</h3>");
        writer.append("<p>Id:" + questionnaires.getId() + "</p>");
        writer.append("<p>Title:" + questionnaires.getTitle() + "</p>");
        writer.append("<p>Desc:" + questionnaires.getDescription() + "</p>");
        writer.append("</body></html>");
    }
}
