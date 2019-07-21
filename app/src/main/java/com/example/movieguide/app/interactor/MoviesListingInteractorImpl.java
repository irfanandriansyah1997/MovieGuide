package com.example.movieguide.app.interactor;

import com.example.movieguide.app.store.SortingOptionStore;
import com.example.movieguide.interfaces.SortType;
import com.example.movieguide.model.Movie;
import com.example.movieguide.services.TmdbWebService;
import com.example.movieguide.wrapper.MovieWrapper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import android.support.annotation.NonNull;
import io.reactivex.Observable;

public class MoviesListingInteractorImpl implements MoviesListingInteractor {
    private FavoritesInteractor favoritesInteractor;
    private TmdbWebService tmdbWebService;
    private SortingOptionStore sortingOptionStore;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final int NEWEST_MIN_VOTE_COUNT = 50;

    public MoviesListingInteractorImpl(FavoritesInteractor favoritesInteractor,
                                TmdbWebService tmdbWebService, SortingOptionStore store) {
        this.favoritesInteractor = favoritesInteractor;
        this.tmdbWebService = tmdbWebService;
        sortingOptionStore = store;
    }


    @Override
    public boolean isPaginationSupported() {
        int selectedOption = sortingOptionStore.getSelectedOption();
        return selectedOption != SortType.FAVORITES.getValue();
    }

    @Override
    public Observable<List<Movie>> fetchMovies(int page) {
        int selectedOption = sortingOptionStore.getSelectedOption();
        if (selectedOption == SortType.MOST_POPULAR.getValue()) {
            return tmdbWebService.popularMovies(page).map(MovieWrapper::getMovieList);
        } else if (selectedOption == SortType.HIGHEST_RATED.getValue()) {
            return tmdbWebService.highestRatedMovies(page).map(MovieWrapper::getMovieList);
        } else if (selectedOption == SortType.NEWEST.getValue()) {
            Calendar cal = Calendar.getInstance();
            String maxReleaseDate = dateFormat.format(cal.getTime());
            return tmdbWebService.newestMovies(maxReleaseDate, NEWEST_MIN_VOTE_COUNT).map(MovieWrapper::getMovieList);
        } else {
            return Observable.just(favoritesInteractor.getFavorites());
        }
    }

    @Override
    public Observable<List<Movie>> searchMovie(@NonNull String searchQuery) {
        return tmdbWebService.searchMovies(searchQuery).map(MovieWrapper::getMovieList);
    }

}
