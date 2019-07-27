package com.example.movieguide.app.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.movieguide.app.fragment.Onboarding1Fragment;
import com.example.movieguide.app.fragment.Onboarding2Fragment;
import com.example.movieguide.app.fragment.Onboarding3Fragment;

public class OnboardingAdapter extends FragmentPagerAdapter {
    private static int ITEM_COUNT = 3;

    public OnboardingAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Onboarding1Fragment();
            case 1:
                return new Onboarding2Fragment();
            case 2:
                return new Onboarding3Fragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return ITEM_COUNT;
    }
}
