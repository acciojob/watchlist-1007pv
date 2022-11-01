package com.driver;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MovieRepository {
    public MovieRepository() {}
    private HashMap<String, Movie> movieHashMap = new HashMap<>();
    private HashMap<String, Director> directorHashMap = new HashMap<>();
    private HashMap<String, List<Movie>> movieDirectorHashMap = new HashMap<>();

    public void addMovie(Movie movie){
        Movie movieObj = new Movie(movie.getName(), movie.getDurationInMinutes(), movie.getImdbRating());
        movieHashMap.put(movieObj.getName(),movieObj);
    }

    public void addDirector(Director director){
        Director directorObj = new Director(director.getName(), director.getNumberOfMovies(), director.getImdbRating());
        directorHashMap.put(directorObj.getName(),directorObj);
    }

    public void addMovieDirectorPair(String directorName, String movieName){
        Movie movie = movieHashMap.get(movieName);
        if(movieDirectorHashMap.containsKey(directorName)){
            movieDirectorHashMap.get(directorName).add(movie);
        }
        else{
            List<Movie> movieList = new ArrayList<>();
            movieList.add(movie);
            movieDirectorHashMap.put(directorName,movieList);
        }
    }

    public Movie getMovieByName(String name){
        return movieHashMap.get(name);
    }

    public Director getDirectorByName(String name){
        return directorHashMap.get(name);
    }

    public List<Movie> getMoviesByDirectorName(){
        List<Movie> movieList = new ArrayList<>(movieHashMap.values());
        return movieList;
    }

    public List<Movie> findAllMovies() {
        List<Movie> movieList = new ArrayList<>(movieHashMap.values());
        return movieList;
    }

    public void deleteDirectorByName(String directorName) {
        List<Movie> movieListByDirector = movieDirectorHashMap.get(directorName);

        for(Movie map : movieListByDirector) {
            movieHashMap.remove(map.getName());
        }
         directorHashMap.remove(directorName);
        movieDirectorHashMap.remove(directorName);
    }

    public Director deleteAllDirectors() {
        directorHashMap = new HashMap<>();
        return null;
    }
}
