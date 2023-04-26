package com.geekster.jokes.controllers;

import com.geekster.jokes.models.Jokes;
import com.geekster.jokes.services.JokesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
    public Jokes getJokesById(@PathVariable String id){
    Jokes jokes = jokesService.getById(id);
    return jokes;
    }

    @PostMapping(value = "/saveJokes")
    public String addJokes(@Validated @RequestBody Jokes jokes){
    return jokesService.Jokesadd(jokes);
    }
    @PutMapping("/{id}")
    public String updateJokes (@PathVariable String id,@RequestBody Jokes user){
    return jokesService.updateById(id,user);
    }
    @DeleteMapping("/{id}")
    public String deleteJokes(@PathVariable String id){
    return jokesService.delete(id);
    }
}
