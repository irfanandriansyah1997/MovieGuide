package com.example.movieguide.app.component;

import com.example.movieguide.app.module.DetailsModule;
import com.example.movieguide.app.module.FavoritesModule;
import com.example.movieguide.app.module.ListingModule;
import com.example.movieguide.module.AppModules;
import com.example.movieguide.module.NetworkModules;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author arunsasidharan
 * @author pulkitkumar
 */
@Singleton
@Component(modules = {
        AppModules.class,
        NetworkModules.class,
        FavoritesModule.class})
public interface AppComponent
{
    DetailsComponent plus(DetailsModule detailsModule);

    ListingComponent plus(ListingModule listingModule);
}
