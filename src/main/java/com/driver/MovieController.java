package com.driver;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MovieService movieService;
    
    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){

        movieRepository.addMovie(movie);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody() Director director){

        movieRepository.addDirector(director);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String movie, @RequestParam("director") String dir){

        movieRepository.update_dirMovieList(dir, movie);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String name){

        Movie movie = movieRepository.getMovie(name);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String name){

        Director director = movieRepository.getDirector(name);
        return new ResponseEntity<>(director, HttpStatus.OK);
    }

    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String dirName){

        List<String> curr = movieRepository.getList(dirName);
        return new ResponseEntity<>(curr, HttpStatus.OK);
    }
    
    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){

        List<String> currList = movieRepository.getMovies();
        return new ResponseEntity<>(currList, HttpStatus.OK);
    }

    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("dirName") String dir){

        movieRepository.deleteDirAndMovies(dir);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        HashMap<String, Director> dirList = movieRepository.getDirectors();
        List<String> dlist = new ArrayList<>();
        for(String i: dirList.keySet()){
            dlist.add(i);
        }
        for(String i: dlist){
            movieRepository.deleteDirAndMovies(i);
        }

        return new ResponseEntity<>("success",HttpStatus.OK);
    }



}