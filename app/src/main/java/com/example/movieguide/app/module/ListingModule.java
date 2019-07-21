package com.example.movieguide.app.module;

import com.example.movieguide.app.interactor.FavoritesInteractor;
import com.example.movieguide.app.interactor.MoviesListingInteractor;
import com.example.movieguide.app.interactor.MoviesListingInteractorImpl;
import com.example.movieguide.app.presenter.MoviesListing.MoviesListingPresenter;
import com.example.movieguide.app.presenter.MoviesListing.MoviesListingPresenterImpl;
import com.example.movieguide.app.store.SortingOptionStore;
import com.example.movieguide.services.TmdbWebService;

import dagger.Module;
import dagger.Provides;

@Module
public class ListingModule {
    @Provides
    MoviesListingInteractor provideMovieListingInteractor(FavoritesInteractor favoritesInteractor,
                                                          TmdbWebService tmdbWebService,
                                                          SortingOptionStore sortingOptionStore) {
        return new MoviesListingInteractorImpl(favoritesInteractor, tmdbWebService, sortingOptionStore);
    }

    @Provides
    MoviesListingPresenter provideMovieListingPresenter(MoviesListingInteractor interactor) {
        return new MoviesListingPresenterImpl(interactor);
    }
}
