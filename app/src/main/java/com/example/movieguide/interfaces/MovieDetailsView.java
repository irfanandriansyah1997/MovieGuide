package com.example.movieguide.interfaces;

import com.example.movieguide.model.Movie;
import com.example.movieguide.model.Review;
import com.example.movieguide.model.Video;

import java.util.List;

/**
 * @author arun
 */
public interface MovieDetailsView
{
    void showDetails(Movie movie);
    void showTrailers(List<Video> trailers);
    void showReviews(List<Review> reviews);
    void showFavorited();
    void showUnFavorited();
}
