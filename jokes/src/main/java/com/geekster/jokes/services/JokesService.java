package com.geekster.jokes.services;

import com.geekster.jokes.models.Jokes;
import com.geekster.jokes.repository.JokesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JokesService {
    @Autowired
  private  JokesDao jokesDao;
    public List<Jokes> getAllJokes() {
        return jokesDao.getjokesList();
    }


    public String Jokes(Jokes jokes) {
return JokesDao.add(jokes)?"jokes added successfully":"an error occured while adding";
    }
    public Jokes getById(int id) {
        Jokes jokes=null;
        boolean found =this.getAllJokes().stream().anyMatch(e->e.getId()==id);
        if(found) jokes=this.getAllJokes().stream().filter(e->e.getId()==id).findFirst().get();
        else{
            System.out.println("no result found with is id");
            return null;
        }
        return jokes;
    }
    public  String updateById(int id) {
        List<Jokes> curJokes = this.getAllJokes();
        for (Jokes jokes : curJokes) {
            if (jokes.getId() == id) {
                JokesDao.remove(jokes);
                JokesDao.add(jokes);
                return "update successfully";
            }
        }
            return "no result fount in this id";
        }

        public  String delete(int id) {
            Jokes jokes=null;
            boolean found =this.getAllJokes().stream().anyMatch(e->e.getId()==id);
            if(found) {
                jokes = this.getAllJokes().stream().filter(e -> e.getId() == id).findFirst().get();
                JokesDao.remove(jokes);
                return "delete successfully";
            }
            return "no jokes found to delete";
        }
    }

