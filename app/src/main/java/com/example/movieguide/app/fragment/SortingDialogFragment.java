package com.example.movieguide.app.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;


import com.example.movieguide.BaseApplication;
import com.example.movieguide.R;
import com.example.movieguide.app.presenter.MoviesListing.MoviesListingPresenter;
import com.example.movieguide.app.presenter.SortingDialog.SortingDialogPresenter;
import com.example.movieguide.interfaces.SortingDialogView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Irfan Andriansyah
 */
public class SortingDialogFragment extends DialogFragment implements SortingDialogView, RadioGroup.OnCheckedChangeListener
{
    @Inject
    SortingDialogPresenter sortingDialogPresenter;

    @BindView(R.id.most_popular)
    RadioButton mostPopular;
    @BindView(R.id.highest_rated)
    RadioButton highestRated;
    @BindView(R.id.favorites)
    RadioButton favorites;
    @BindView(R.id.newest)
    RadioButton newest;
    @BindView(R.id.sorting_group)
    RadioGroup sortingOptionsGroup;

    private static MoviesListingPresenter moviesListingPresenter;
    private Unbinder unbinder;

    public static SortingDialogFragment newInstance(MoviesListingPresenter moviesListingPresenter)
    {
        SortingDialogFragment.moviesListingPresenter = moviesListingPresenter;
        return new SortingDialogFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        ((BaseApplication) getActivity().getApplication()).getListingComponent().inject(this);
        sortingDialogPresenter.setView(this);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(R.layout.sorting_options, null);
        unbinder = ButterKnife.bind(this, dialogView);
        initViews();

        Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(dialogView);
        dialog.show();
        return dialog;
    }

    private void initViews()
    {
        sortingDialogPresenter.setLastSavedOption();
        sortingOptionsGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void setPopularChecked()
    {
        mostPopular.setChecked(true);
    }


    @Override
    public void setNewestChecked()
    {
        newest.setChecked(true);
    }

    @Override
    public void setHighestRatedChecked()
    {
        highestRated.setChecked(true);
    }

    @Override
    public void setFavoritesChecked()
    {
        favorites.setChecked(true);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId)
    {
        switch (checkedId)
        {
            case R.id.most_popular:
                sortingDialogPresenter.onPopularMoviesSelected();
                moviesListingPresenter.firstPage();
                break;

            case R.id.highest_rated:
                sortingDialogPresenter.onHighestRatedMoviesSelected();
                moviesListingPresenter.firstPage();
                break;

            case R.id.favorites:
                sortingDialogPresenter.onFavoritesSelected();
                moviesListingPresenter.firstPage();
                break;
            case R.id.newest:
                sortingDialogPresenter.onNewestMoviesSelected();
                moviesListingPresenter.firstPage();
                break;
        }
    }

    @Override
    public void dismissDialog()
    {
        dismiss();
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        sortingDialogPresenter.destroy();
        unbinder.unbind();
    }
}

