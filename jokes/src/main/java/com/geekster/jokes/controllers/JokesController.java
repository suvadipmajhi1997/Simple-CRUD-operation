package com.geekster.jokes.controllers;

import com.geekster.jokes.models.Jokes;
import com.geekster.jokes.services.JokesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/jokes")
public class JokesController {
    @Autowired
    private JokesService jokesService;
    @GetMapping(value = "/getallJokes")
    public List<Jokes> getJokes(){
        return jokesService.getAllJokes();
    }
    @GetMapping("/{id}")
    public Jokes getJokesById(@PathVariable int id){
    Jokes jokes = jokesService.getById(id);
    return jokes;
    }

    @PostMapping(value = "/saveJokes")
    public String addJokes(@RequestBody Jokes jokes){
    return JokesService.Jokes(jokes);
    }
    @PutMapping("/{id}")
    public String updateJokes (@RequestBody int id){
    return JokesService.updateById(id);
    }
    @DeleteMapping("/{id}")
    public String deleteJokes(@PathVariable int id){
    return JokesService.delete(id);
    }
}
