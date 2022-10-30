package com.driver;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Component
public class MovieRepository {

    static HashMap<Integer, Movie> movieHashMap = new HashMap<>();
    static HashMap<Integer, Director> directorHashMap = new HashMap<>();
    static HashMap<Movie, Director> movieDirectorHashMap = new HashMap<>();

    static void addMovie(Movie movie){
        movieHashMap.put(movie.getId(),movie);
    }

    static void addDirector(Director director){
        directorHashMap.put(director.getId(),director);
    }

    static void addMovieDirectorPair(Movie movie,Director director){
        movieDirectorHashMap.put(movie,director);
    }

    static Movie getMovieByName(String name){
            for(Map.Entry mapElement : movieHashMap.entrySet()){
                if(mapElement.getValue()==name) {
                    return movieHashMap.get(name);
                }
            }
            return new Movie();
    }

    static Director getDirectorByName(String name){
        for(Map.Entry mapElement : directorHashMap.entrySet()){
            if(mapElement.getValue()==name) {
                return directorHashMap.get(name);
            }
        }
        return new Director();
    }

    static List<Movie> getMoviesByDirectorName(){
        List<Movie> movieList = new ArrayList<>();
        for(Movie movie : movieHashMap.values()){
            movieList.add(movie);
        }
        return movieList;
    }

    static List<Movie> getAllMovies() {
        List<Movie> movieList = new ArrayList<>();
        for(Movie movie : movieHashMap.values()){
            movieList.add(movie);
        }
        return movieList;
    }

    static Movie deleteDirectorByName(String name) {
        return movieHashMap.remove(name);
    }

    public static Director deleteAllDirectors(String name) {
        return directorHashMap.remove(name);
    }


/*

    Delete a director and its movies from the records: DELETE /movies/delete-director-by-name
    Pass director’s name as request parameter
    Return success message wrapped in a ResponseEntity object
    Controller Name - deleteDirectorByName

    Delete all directors and all movies by them from the records: DELETE /movies/delete-director-by-name
    No params or body required
    Return success message wrapped in a ResponseEntity object
    Controller Name - deleteAllDirectors
            (Note that there can be some movies on your watchlist that aren’t mapped to any of the director. Make sure you do not remove them.)



Get Movie by movie name: GET /movies/get-movie-by-name/{name}
    Pass movie name as path parameter
    Return Movie object wrapped in a ResponseEntity object
    Controller Name - getMovieByName

    Get Director by director name: GET /movies/get-director-by-name/{name}
    Pass director name as path parameter
    Return Director object wrapped in a ResponseEntity object
    Controller Name - getDirectorByName

    Get List of movies name for a given director name: GET /movies/get-movies-by-director-name/{director}
    Pass director name as path parameter
    Return List of movies name(List()) wrapped in a ResponseEntity object
    Controller Name - getMoviesByDirectorName

    */
}
