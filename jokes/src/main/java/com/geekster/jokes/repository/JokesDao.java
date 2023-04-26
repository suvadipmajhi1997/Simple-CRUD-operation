package com.geekster.jokes.repository;

import com.geekster.jokes.models.Jokes;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class JokesDao {
    List<Jokes> JokesList = new ArrayList<>();

    public List<Jokes> getjokesList() {
        return this.JokesList;
    }

    public boolean add(Jokes jokes) {
        JokesList.add(jokes);
        return true;
    }

    public boolean remove(Jokes jokes) {
        JokesList.remove(jokes);
        return true;
    }

    public boolean updateUserById(String id, Jokes user) {
        for (Jokes jokesObj : JokesList) {
            if (jokesObj.getUserId().equals(id)) {
                jokesObj.setUserName(user.getUserName());
                jokesObj.setDateOfBirth(user.getDateOfBirth());
                jokesObj.setEmail(user.getEmail());
                jokesObj.setPhoneNumber(user.getPhoneNumber());
                jokesObj.setDate(user.getDate());
                jokesObj.setTime(user.getTime());
                return true;
            }
        }
        return false;
    }
}
