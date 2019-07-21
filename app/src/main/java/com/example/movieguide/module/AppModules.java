package com.example.movieguide.module;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

@Module
public class AppModules {
    private Context context;

    public AppModules(Application application)
    {
        context = application;
    }

    @Provides
    @Singleton
    public Context provideContext()
    {
        return context;
    }

    @Provides
    @Singleton
    public Resources provideResources(Context context)
    {
        return context.getResources();
    }

    @Provides
    @Singleton
    public Realm provideRealm()
    {
        return Realm.getDefaultInstance();
    }
}
