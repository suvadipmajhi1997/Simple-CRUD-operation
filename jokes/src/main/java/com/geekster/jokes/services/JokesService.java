package com.geekster.jokes.services;

import com.geekster.jokes.models.Jokes;
import com.geekster.jokes.repository.JokesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JokesService {
    @Autowired
    private JokesDao jokesDao;

    public List<Jokes> getAllJokes() {
        return jokesDao.getjokesList();
    }


    public String Jokesadd(Jokes jokes) {
        return jokesDao.add(jokes) ? "jokes added successfully" : "an error occured while adding";
    }

    public Jokes getById(String id) {
        List<Jokes> curntjokes = getAllJokes();
        for (Jokes found : curntjokes) {
            if (found.getUserId().equals(id))

                return found;
        }
        System.out.println("no result found with is id");
        return null;
    }

    public String updateById(String id,Jokes user) {
        boolean updateStatus = jokesDao.updateUserById(id,user);

        if (updateStatus) {
            return "User: " + id + " was updated!!!";
        } else {
            return "User: " + id + " does not exist!!!";
        }
    }

    public String delete(String id) {
        List<Jokes> curntjokes = getAllJokes();
        for (Jokes found : curntjokes) {
            if (found.getUserId().equals(id)) {
                boolean status = jokesDao.remove(found);
                if (status) {

                    return "delete successfully";
                }

            }

        }
        return "no jokes found to delete";
    }
}
