package com.example.movieguide.app.interactor;

import com.example.movieguide.app.store.FavoritesStore;
import com.example.movieguide.model.Movie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FavoritesInteractorImpl implements FavoritesInteractor
{
    private FavoritesStore favoritesStore;

    public FavoritesInteractorImpl(FavoritesStore store)
    {
        favoritesStore = store;
    }

    @Override
    public void setFavorite(Movie movie)
    {
        favoritesStore.setFavorite(movie);
    }

    @Override
    public boolean isFavorite(String id)
    {
        return favoritesStore.isFavorite(id);
    }

    @Override
    public List<Movie> getFavorites()
    {
        return favoritesStore.getFavorites();
    }

    @Override
    public void unFavorite(String id)
    {
        favoritesStore.unfavorite(id);
    }
}
