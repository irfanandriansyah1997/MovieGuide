package com.example.movieguide.wrapper;

import com.example.movieguide.model.Movie;
import com.squareup.moshi.Json;
import java.util.List;

/**
 * @author Irfan Andriansyah
 */

public class MovieWrapper {

    @Json(name = "results")
    private List<Movie> movies;

    public List<Movie> getMovieList() {
        return movies;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movies = movieList;
    }
}

