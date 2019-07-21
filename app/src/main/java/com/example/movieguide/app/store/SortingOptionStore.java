package com.example.movieguide.app.store;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.movieguide.interfaces.SortType;

import javax.inject.Inject;

public class SortingOptionStore
{
    private SharedPreferences pref;
    private static final String SELECTED_OPTION = "selectedOption";
    private static final String PREF_NAME = "SortingOptionStore";

    @Inject
    public SortingOptionStore(Context context)
    {
        pref = context.getApplicationContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void setSelectedOption(SortType sortType)
    {
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(SELECTED_OPTION, sortType.getValue());
        editor.apply();
    }

    public int getSelectedOption()
    {
        return pref.getInt(SELECTED_OPTION, 0);
    }
}
