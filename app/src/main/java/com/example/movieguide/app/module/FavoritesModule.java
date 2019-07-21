package com.example.movieguide.app.module;


import com.example.movieguide.app.interactor.FavoritesInteractor;
import com.example.movieguide.app.interactor.FavoritesInteractorImpl;
import com.example.movieguide.app.store.FavoritesStore;
import com.example.movieguide.module.AppModules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author pulkitkumar
 */
@Module(includes = AppModules.class)
public class FavoritesModule
{
    @Provides
    @Singleton
    FavoritesInteractor provideFavouritesInteractor(FavoritesStore store)
    {
        return new FavoritesInteractorImpl(store);
    }
}
