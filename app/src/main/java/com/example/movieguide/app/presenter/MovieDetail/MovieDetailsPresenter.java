package com.example.movieguide.app.presenter.MovieDetail;

import com.example.movieguide.interfaces.MovieDetailsView;
import com.example.movieguide.model.Movie;

/**
 * @author Irfan Andriansyah
 */
public interface MovieDetailsPresenter
{
    void showDetails(Movie movie);

    void showTrailers(Movie movie);

    void showReviews(Movie movie);

    void showFavoriteButton(Movie movie);

    void onFavoriteClick(Movie movie);

    void setView(MovieDetailsView view);

    void destroy();
}