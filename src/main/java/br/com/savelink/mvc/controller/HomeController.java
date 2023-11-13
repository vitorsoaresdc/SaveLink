package br.com.savelink.mvc.controller;

import br.com.savelink.mvc.model.Link;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/home")
    public String home(Model model) {

        Link link = new Link();
        Query query = entityManager.createQuery("SELECT p FROM Link p", Link.class);
        List<Link> links = query.getResultList();

        model.addAttribute("links", links);
        return "home";
    }
}
