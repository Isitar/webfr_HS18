package ch.fhnw.webfr.flashcard.web;

import ch.fhnw.webfr.flashcard.domain.Questionnaire;
import ch.fhnw.webfr.flashcard.persistence.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/questionnaires")
public class QuestionnareController {

    @Autowired
    private QuestionnaireRepository questionnaireRepository;


    @GetMapping()
    public String findAll(Model model, @RequestParam(required = false) String errorMessage, @RequestParam(required = false) String successMessage) throws IOException {
        List<Questionnaire> questionnaires = questionnaireRepository.findAll();
        model.addAttribute ("questionnaires", questionnaires);
        model.addAttribute("successMessage", successMessage);
        model.addAttribute("errorMessage", errorMessage);

        System.out.println("Success message: " + successMessage);
        System.out.println("Error message: " + errorMessage);

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

    @GetMapping("/update/{id}")
    public String update(@PathVariable String id, Model model){
        Questionnaire q = questionnaireRepository.findById(id).get();
        model.addAttribute("questionnaire", q);
        return "questionnaires/update";
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable String id, @Valid Questionnaire questionnaire, BindingResult result, Model model){
        if (result.hasErrors()) {
            System.out.println("Error!");
            return "questionnaires/create";
        }
        Questionnaire q = questionnaireRepository.findById(id).get();
        q.setTitle(questionnaire.getTitle());
        q.setDescription(questionnaire.getDescription());
        questionnaireRepository.save(q);
        System.out.println("new title: " + questionnaire.getTitle() + " new desc: " + questionnaire.getDescription());
        return "redirect:/questionnaires?successMessage=Erfolgreich bearbeitet";
    }

    @PostMapping()
    public String create(@Valid Questionnaire questionnaire, BindingResult result) throws IOException {
        if (result.hasErrors()) {
            System.out.println("Error!");
            return "questionnaires/create";
        }
        questionnaireRepository.insert(questionnaire);
        return "redirect:/questionnaires?successMessage=Erfolgreich erstellt";
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable String id) {
        questionnaireRepository.deleteById(id);

        return "redirect:/questionnaires?successMessage=Erfolgreich gelöscht";
    }
}
