package com.example.movieguide;

import android.app.Application;
import android.os.StrictMode;

import com.example.movieguide.app.component.AppComponent;
import com.example.movieguide.app.component.DaggerAppComponent;
import com.example.movieguide.app.component.DetailsComponent;
import com.example.movieguide.app.component.ListingComponent;
import com.example.movieguide.app.module.DetailsModule;
import com.example.movieguide.app.module.FavoritesModule;
import com.example.movieguide.app.module.ListingModule;
import com.example.movieguide.module.AppModules;
import com.example.movieguide.module.NetworkModules;

import io.realm.Realm;

public class BaseApplication extends Application
{
    private AppComponent appComponent;
    private DetailsComponent detailsComponent;
    private ListingComponent listingComponent;

    @Override
    public void onCreate()
    {
        super.onCreate();
        StrictMode.enableDefaults();
        initRealm();
        appComponent = createAppComponent();
    }

    private AppComponent createAppComponent()
    {
        return DaggerAppComponent.builder()
                .appModules(new AppModules(this))
                .networkModules(new NetworkModules())
                .favoritesModule(new FavoritesModule())
                .build();
    }

    private void initRealm(){
        Realm.init(this);
    }

    public DetailsComponent createDetailsComponent()
    {
        detailsComponent = appComponent.plus(new DetailsModule());
        return detailsComponent;
    }

    public void releaseDetailsComponent()
    {
        detailsComponent = null;
    }

    public ListingComponent createListingComponent()
    {
        listingComponent = appComponent.plus(new ListingModule());
        return listingComponent;
    }

    public void releaseListingComponent()
    {
        listingComponent = null;
    }

    public ListingComponent getListingComponent()
    {
        return listingComponent;
    }
}
