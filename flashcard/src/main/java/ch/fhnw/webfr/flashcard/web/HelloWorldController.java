package ch.fhnw.webfr.flashcard.web;

import ch.fhnw.webfr.flashcard.persistence.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("hello")
public class HelloWorldController {

    @Autowired
    QuestionnaireRepository questionnaireRepository;

    @GetMapping()
    public @ResponseBody String get(@RequestParam String name) throws IOException {
        StringBuilder writer = new StringBuilder();
        writer.append("<html><head><title>Example</title></head><body>");
        writer.append("<h3> Hallo " + name +"</h3>");
        writer.append("<p> Anzahl Q: " + questionnaireRepository.count() +"</p>");

        writer.append("</body></html>");
        return writer.toString();
    }
}
