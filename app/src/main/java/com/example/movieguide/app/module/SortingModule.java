package com.example.movieguide.app.module;

import com.example.movieguide.app.interactor.SortingDialogInteractor;
import com.example.movieguide.app.interactor.SortingDialogInteractorImpl;
import com.example.movieguide.app.presenter.SortingDialog.SortingDialogPresenter;
import com.example.movieguide.app.presenter.SortingDialog.SortingDialogPresenterImpl;
import com.example.movieguide.app.store.SortingOptionStore;

import dagger.Module;
import dagger.Provides;

@Module
public class SortingModule
{
    @Provides
    SortingDialogInteractor providesSortingDialogInteractor(SortingOptionStore store)
    {
        return new SortingDialogInteractorImpl(store);
    }

    @Provides
    SortingDialogPresenter providePresenter(SortingDialogInteractor interactor)
    {
        return new SortingDialogPresenterImpl(interactor);
    }
}
