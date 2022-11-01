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
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody()Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody()Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }

    @PostMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("directorName")String directorName,@RequestParam("movieName")String movieName){
        movieService.addMovieDirectorPair(directorName,movieName);
        return new ResponseEntity("Success",HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathParam("name") String name) {
        return new ResponseEntity<>(movieService.getMovieByName(name),HttpStatus.OK);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathParam("name") String name) {
        return new ResponseEntity<>(movieService.getDirectorByName(name),HttpStatus.OK);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<Movie>> getMoviesByDirectorName(@PathParam("name") String name) {
        return new ResponseEntity<>(movieService.getMoviesByDirectorName(),HttpStatus.OK);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<Movie>> findAllMovies(){
        return new ResponseEntity<>(movieService.findAllMovies(),HttpStatus.OK);
    }

    @DeleteMapping("/delete-director-by-name/{name}")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("directorName") String directorName){
        movieService.deleteDirectorByName(directorName);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("Success",HttpStatus.OK);
    }

}
