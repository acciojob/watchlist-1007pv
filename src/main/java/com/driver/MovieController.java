package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String name) {
        if(movieService.getMovieByName(name)!=null) {
            return new ResponseEntity<>(movieService.getMovieByName(name), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String name) {
        if(movieService.getDirectorByName(name)!=null) {
            return new ResponseEntity<>(movieService.getDirectorByName(name), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String directorName) {
        List<String> movieList = movieService.getMoviesByDirectorName(directorName);
        return new ResponseEntity<>(movieList,HttpStatus.OK);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> listOfMovies = movieService.findAllMovies();
        return new ResponseEntity<>(listOfMovies,HttpStatus.OK);
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
