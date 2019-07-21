package com.example.movieguide.app.interactor;

import com.example.movieguide.interfaces.SortType;

public interface SortingDialogInteractor
{
    int getSelectedSortingOption();

    void setSortingOption(SortType sortType);
}
