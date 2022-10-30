package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository repository;

    public static void addMovie(Movie movie) {
        MovieRepository.addMovie(movie);
    }

    public static void addDirector(Director director){
        MovieRepository.addDirector(director);
    }
    public static void addMovieDirectorPair(Movie movie, Director director){
        MovieRepository.addMovieDirectorPair(movie,director);
    }

    public static Movie getMovieByName(String name) {
        return MovieRepository.getMovieByName(name);
    }

    public static Director getDirectorByName(String name) {
        return MovieRepository.getDirectorByName(name);
    }

    public static List<Movie> getMoviesByDirectorName() {
        return MovieRepository.getMoviesByDirectorName();
    }

    public static List<Movie> findAllMovies() {
        return MovieRepository.findAllMovies();
    }

    public static Movie deleteDirectorByName(String name) {
        return MovieRepository.deleteDirectorByName(name);
    }

    public static Director deleteAllDirectors(String name) {
        return MovieRepository.deleteAllDirectors(name);
    }
}
