package com.example.movieguide.app.module;

import com.example.movieguide.app.interactor.FavoritesInteractor;
import com.example.movieguide.app.interactor.MovieDetailsInteractor;
import com.example.movieguide.app.interactor.MovieDetailsInteractorImpl;
import com.example.movieguide.app.presenter.MovieDetail.MovieDetailsPresenter;
import com.example.movieguide.app.presenter.MovieDetail.MovieDetailsPresenterImpl;
import com.example.movieguide.app.scope.DetailsScope;
import com.example.movieguide.services.TmdbWebService;

import dagger.Module;
import dagger.Provides;

/**
 * @author pulkitkumar
 * @author arunsasidharan
 */
@Module
public class DetailsModule {
    @Provides
    @DetailsScope
    MovieDetailsInteractor provideInteractor(TmdbWebService tmdbWebService) {
        return new MovieDetailsInteractorImpl(tmdbWebService);
    }

    @Provides
    @DetailsScope
    public MovieDetailsPresenter providePresenter(MovieDetailsInteractor detailsInteractor,
                                                  FavoritesInteractor favoritesInteractor) {
        return new MovieDetailsPresenterImpl(detailsInteractor, favoritesInteractor);
    }
}
