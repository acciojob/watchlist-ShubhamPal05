package com.driver;
import org.springframework.stereotype.Component;

/**
 * Director
 */
@Component
public class Director {

    private String name;
    private int numberOfMovies;
    private double imdbRating;

    public Director(){

    }

    public Director(String name, int n, double rating){
        this.name = name;
        this.numberOfMovies = n;
        this.imdbRating = rating;
    }

    public String getName() {
        return name;
    }
    public int getNumberOfMovies() {
        return numberOfMovies;
    }
    public double getImdbRating() {
        return imdbRating;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setNumberOfMovies(int numberOfMovies) {
        this.numberOfMovies = numberOfMovies;
    }
    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }
}