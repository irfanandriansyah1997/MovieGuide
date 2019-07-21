package com.example.movieguide.app.interactor;

import com.example.movieguide.model.Review;
import com.example.movieguide.model.Video;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author arun
 */
public interface MovieDetailsInteractor
{
    Observable<List<Video>> getTrailers(String id);
    Observable<List<Review>> getReviews(String id);
}
