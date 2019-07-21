package com.example.movieguide.app.activity;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.movieguide.R;
import com.example.movieguide.app.fragment.MovieDetailsFragment;
import com.example.movieguide.constant.Constants;
import com.example.movieguide.model.Movie;

public class MovieDetailsActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        if (savedInstanceState == null)
        {
            Bundle extras = getIntent().getExtras();
            if (extras != null && extras.containsKey(Constants.MOVIE))
            {
                Movie movie = extras.getParcelable(Constants.MOVIE);
                if (movie != null)
                {
                    MovieDetailsFragment movieDetailsFragment = MovieDetailsFragment.getInstance(movie);
                    getSupportFragmentManager().beginTransaction().add(R.id.movie_details_container, movieDetailsFragment).commit();
                }
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);
    }
}
