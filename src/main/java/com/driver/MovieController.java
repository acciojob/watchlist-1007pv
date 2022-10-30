package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService services;


    @PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody()Movie movie){
        MovieService.addMovie(movie);
        return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody()Director director){
        MovieService.addDirector(director);
        return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }

    @PostMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestBody()Movie movie,Director director){
        MovieService.addMovieDirectorPair(movie,director);
        return new ResponseEntity("Success",HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathParam("name") String name) {
        return new ResponseEntity<>(MovieService.getMovieByName(name),HttpStatus.OK);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathParam("name") String name) {
        return new ResponseEntity<>(MovieService.getDirectorByName(name),HttpStatus.OK);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<Movie>> getMoviesByDirectorName(@PathParam("name") String name) {
        return new ResponseEntity<>(MovieService.getMoviesByDirectorName(),HttpStatus.OK);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<Movie>> findAllMovies(){
        return new ResponseEntity<>(MovieService.findAllMovies(),HttpStatus.OK);
    }

    @DeleteMapping("/delete-director-by-name/{name}")
    public ResponseEntity deleteDirectorByName(@PathParam("name") String name){
        return new ResponseEntity<>(MovieService.deleteDirectorByName(name),HttpStatus.OK);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteAllDirectors(String name){
        return new ResponseEntity<>("Success",HttpStatus.OK);
    }
}
