package com.example.movieguide.interfaces;

import com.example.movieguide.model.Movie;

import java.util.List;

/**
 * @author Irfan Andriansyah
 */
public interface MoviesListingView
{
    void showMovies(List<Movie> movies);
    void loadingStarted();
    void loadingFailed(String errorMessage);
    void onMovieClicked(Movie movie);
}
