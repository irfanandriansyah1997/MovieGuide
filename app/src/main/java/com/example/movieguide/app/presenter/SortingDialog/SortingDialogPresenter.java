package com.example.movieguide.app.presenter.SortingDialog;

import com.example.movieguide.interfaces.SortingDialogView;

public interface SortingDialogPresenter
{
    void setLastSavedOption();

    void onPopularMoviesSelected();

    void onHighestRatedMoviesSelected();

    void onFavoritesSelected();

    void onNewestMoviesSelected();

    void setView(SortingDialogView view);

    void destroy();
}
