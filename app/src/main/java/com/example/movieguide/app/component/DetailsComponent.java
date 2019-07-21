package com.example.movieguide.app.component;

import com.example.movieguide.app.fragment.MovieDetailsFragment;
import com.example.movieguide.app.module.DetailsModule;
import com.example.movieguide.app.scope.DetailsScope;

import dagger.Subcomponent;

/**
 * @author Irfan Andriansyah
 */
@DetailsScope
@Subcomponent(modules = {DetailsModule.class})
public interface DetailsComponent
{
    void inject(MovieDetailsFragment target);
}
