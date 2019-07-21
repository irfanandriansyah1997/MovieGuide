package com.example.movieguide.app.interactor;

import com.example.movieguide.model.Movie;

import java.util.List;

public interface FavoritesInteractor
{
    void setFavorite(Movie movie);
    boolean isFavorite(String id);
    List<Movie> getFavorites();
    void unFavorite(String id);
}
