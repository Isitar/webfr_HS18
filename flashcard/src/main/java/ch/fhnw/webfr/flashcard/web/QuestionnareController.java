package ch.fhnw.webfr.flashcard.web;

import ch.fhnw.webfr.flashcard.domain.Questionnaire;
import ch.fhnw.webfr.flashcard.persistence.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/questionnaires")
public class QuestionnareController {

    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    @GetMapping()
    public String findAll(Model model) throws IOException {
        List<Questionnaire> questionnaires = questionnaireRepository.findAll();
        model.addAttribute ("questionnaires", questionnaires);
        return "questionnaires/list";
        //PrintWriter writer = response.getWriter();
        //writer.append("<html><head><title>Example</title></head><body>");
        //writer.append("<h3>Fragebögen</h3>");
        //for (Questionnaire questionnaire : questionnaires) {
        //    String url = request.getContextPath() + request.getServletPath();
        //    url = url + "/" + questionnaire.getId().toString();
        //    writer.append("<p><a href='" + response.encodeURL(url) + "'>" + questionnaire.getTitle() + "</a></p>");
        //}
        //writer.append("</body></html>");
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable String id, Model model) throws IOException {
        Questionnaire questionnaire = questionnaireRepository.findById(id).get();
        model.addAttribute("questionnaire", questionnaire);
        return "questionnaires/show";
    }

    @GetMapping(value = "", params = "form")
    public String create(Model model) throws IOException {

        model.addAttribute("questionnaire", new Questionnaire());
        return "questionnaires/create";
    }

    @PostMapping()
    public String create(Questionnaire questionnaire, Model model) throws IOException {
        questionnaireRepository.insert(questionnaire);
        return findAll(model);
    }
}
