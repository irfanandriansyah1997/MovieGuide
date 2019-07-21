package com.example.movieguide.app.interactor;

import com.example.movieguide.app.store.SortingOptionStore;
import com.example.movieguide.interfaces.SortType;

public class SortingDialogInteractorImpl implements SortingDialogInteractor
{
    private SortingOptionStore sortingOptionStore;

    public SortingDialogInteractorImpl(SortingOptionStore store)
    {
        sortingOptionStore = store;
    }

    @Override
    public int getSelectedSortingOption()
    {
        return sortingOptionStore.getSelectedOption();
    }

    @Override
    public void setSortingOption(SortType sortType)
    {
        sortingOptionStore.setSelectedOption(sortType);
    }
}