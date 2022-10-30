package com.driver;
import java.util.*;

import org.springframework.stereotype.Component;

@Component
public class MovieRepository {
    

    HashMap<String, Movie> movies = new HashMap<>();

    HashMap<String, Director> directors = new HashMap<>();

    HashMap<String, List<String>> dirMovieList = new HashMap<>();//key dir, value movie-name list


    public void addMovie(Movie movie){
        movies.put(movie.getName(), movie);
    }
    
    public void addDirector(Director director){
        directors.put(director.getName(), director);
    }

    public Movie getMovie(String movie){
        return movies.get(movie);
    }

    public Director getDirector(String dir){
        return directors.get(dir);
    }

    public void update_dirMovieList(String dir, String movie){
        List<String> curr = dirMovieList.get(dir);
        curr.add(movie);
        dirMovieList.put(dir, curr);
    }

    public List<String> getList(String dir){
        return dirMovieList.get(dir);
    }

    public List<String> getMovies(){
        List<String> list = new ArrayList<String>();
        for(String i: movies.keySet()){
            list.add(i);
        }
        return list;
    }

    public void deleteDirAndMovies(String dir){
        List<String> currList = getList(dir);

        for(String i:currList){
            movies.remove(i);
        }
        directors.remove(dir);
        dirMovieList.remove(dir);
    }

    public HashMap<String, Director> getDirectors() {
        return directors;
    }


}
