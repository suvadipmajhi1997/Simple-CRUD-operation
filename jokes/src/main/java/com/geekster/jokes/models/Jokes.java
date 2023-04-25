package com.geekster.jokes.models;

public class Jokes {
    private int id;
    private String jokes;
    private String contributer;

    public Jokes(int id, String jokes, String contributer) {
        this.id = id;
        this.jokes = jokes;
        this.contributer = contributer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJokes() {
        return jokes;
    }

    public void setJokes(String jokes) {
        this.jokes = jokes;
    }

    public String getContributer() {
        return contributer;
    }

    public void setContributer(String contributer) {
        this.contributer = contributer;
    }
}
