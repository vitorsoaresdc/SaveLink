package br.com.savelink.mvc.controller;

import br.com.savelink.mvc.entities.Link;
import br.com.savelink.mvc.repositories.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping(value = "/links")
public class LinksController {

    @Autowired
    private LinkRepository repository;

    @GetMapping
    public List<Link> findAll() {
        return repository.findAll();
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public Link findAll(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping
    public String insert(@ModelAttribute Link link) {
        repository.save(link);
        return "redirect:/home";
    }

    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @ResponseBody
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Link link) {
        return repository.findById(id)
                .map(existingLink -> {
                    existingLink.setUrl(link.getUrl());
                    repository.save(existingLink);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
