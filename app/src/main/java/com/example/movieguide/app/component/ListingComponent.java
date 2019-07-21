package com.example.movieguide.app.component;

import com.example.movieguide.app.fragment.MoviesListingFragment;
import com.example.movieguide.app.fragment.SortingDialogFragment;
import com.example.movieguide.app.module.ListingModule;
import com.example.movieguide.app.module.SortingModule;
import com.example.movieguide.app.scope.ListingScope;

import dagger.Subcomponent;

/**
 * @author arunsasidharan
 */
@ListingScope
@Subcomponent(modules = {ListingModule.class, SortingModule.class})
public interface ListingComponent
{
    MoviesListingFragment inject(MoviesListingFragment fragment);

    SortingDialogFragment inject(SortingDialogFragment fragment);
}
