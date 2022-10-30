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

    public static void addMovie(Movie movie){
        int index = 1;
        movieHashMap.put(index+1,movie);
    }

    public static void addDirector(Director director){
        int index = 1;
        directorHashMap.put(index+1,director);
    }

    public static void addMovieDirectorPair(Movie movie,Director director){
        movieDirectorHashMap.put(movie,director);
    }

    public static Movie getMovieByName(String name){
            for(Map.Entry mapElement : movieHashMap.entrySet()){
                if(mapElement.getValue()==name) {
                    return movieHashMap.get(name);
                }
            }
            return new Movie();
    }

    public static Director getDirectorByName(String name){
        for(Map.Entry mapElement : directorHashMap.entrySet()){
            if(mapElement.getValue()==name) {
                return directorHashMap.get(name);
            }
        }
        return new Director();
    }

    public static List<Movie> getMoviesByDirectorName(){
        List<Movie> movieList = new ArrayList<>();
        for(Movie movie : movieHashMap.values()){
            movieList.add(movie);
        }
        return movieList;
    }

    public static List<Movie> findAllMovies() {
        List<Movie> movieList = new ArrayList<>();
        for(Movie movie : movieHashMap.values()){
            movieList.add(movie);
        }
        return movieList;
    }

    public static Movie deleteDirectorByName(String name) {
        return movieHashMap.remove(name);
    }

    public static Director deleteAllDirectors(String name) {
        return directorHashMap.remove(name);
    }
}
