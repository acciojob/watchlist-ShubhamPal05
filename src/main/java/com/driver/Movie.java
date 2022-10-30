package com.driver;

public class Movie {
    private String name;
    private int durationInMinutes;
    private double imdbRating;

    public Movie(){

    }

    public Movie(String name, int duration, double imdb){
        this.name = name;
        this.durationInMinutes = duration;
        this.imdbRating = imdb;
    }
    //getters
    public String getName(){
        return name;
    }
    public int getDurationInMinutes(){
        return durationInMinutes;
    }
    public double getImdbRating(){
        return imdbRating;
    }
    
    //setters
    public void setName(String name){
        this.name = name;
    }
    public void setDurationInMinutes(int duration){
        this.durationInMinutes = duration;
    }
    public void setImdbRating(double rating){
        this.imdbRating = rating;
    }
}
