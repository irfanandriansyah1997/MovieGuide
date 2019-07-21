package com.example.movieguide.interfaces;

/**
 * @author Irfan Andriansyah
 */
public interface SortingDialogView
{
    void setPopularChecked();
    void setNewestChecked();
    void setHighestRatedChecked();
    void setFavoritesChecked();
    void dismissDialog();

}
