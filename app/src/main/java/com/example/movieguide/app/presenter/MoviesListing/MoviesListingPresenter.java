package com.example.movieguide.app.presenter.MoviesListing;

import com.example.movieguide.interfaces.MoviesListingView;

/**
 * @author Irfan Andriansyah
 */
public interface MoviesListingPresenter
{
    void firstPage();

    void nextPage();

    void setView(MoviesListingView view);

    void searchMovie(String searchText);

    void searchMovieBackPressed();

    void destroy();
}
