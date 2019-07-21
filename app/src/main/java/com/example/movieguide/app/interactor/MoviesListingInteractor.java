package com.example.movieguide.app.interactor;


import com.example.movieguide.model.Movie;

import java.util.List;
import io.reactivex.Observable;

/**
 * @author Irfan Andriansyah
 */
public interface MoviesListingInteractor
{
    boolean isPaginationSupported();
    Observable<List<Movie>> fetchMovies(int page);
    Observable<List<Movie>> searchMovie(String searchQuery);
}
