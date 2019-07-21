package com.example.movieguide.app.interactor;

import com.example.movieguide.model.Review;
import com.example.movieguide.model.Video;
import com.example.movieguide.services.TmdbWebService;
import com.example.movieguide.wrapper.ReviewWrapper;
import com.example.movieguide.wrapper.VideoWrapper;

import java.util.List;
import io.reactivex.Observable;

/**
 * @author arun
 */
public class MovieDetailsInteractorImpl implements MovieDetailsInteractor {

    private TmdbWebService tmdbWebService;

    public MovieDetailsInteractorImpl(TmdbWebService tmdbWebService) {
        this.tmdbWebService = tmdbWebService;
    }

    @Override
    public Observable<List<Video>> getTrailers(final String id) {
        return tmdbWebService.trailers(id).map(VideoWrapper::getVideos);
    }

    @Override
    public Observable<List<Review>> getReviews(final String id) {
        return tmdbWebService.reviews(id).map(ReviewWrapper::getReviews);
    }

}
