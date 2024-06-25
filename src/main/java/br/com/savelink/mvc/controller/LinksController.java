package br.com.savelink.mvc.controller;

import br.com.savelink.mvc.entities.Link;
import br.com.savelink.mvc.repositories.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/links")
public class LinksController {

    @Autowired
    private LinkRepository repository;

    @GetMapping
    public List<Link> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Link findAll(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping
    public Link insert(@ModelAttribute Link link) {
       return repository.save(link);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping("/")
    public void  update(@RequestBody Link link) {
        repository.save(link);
    }



}
