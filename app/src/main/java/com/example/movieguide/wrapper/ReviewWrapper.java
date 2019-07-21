package com.example.movieguide.wrapper;

import com.example.movieguide.model.Review;
import com.squareup.moshi.Json;
import java.util.List;

/**
 * Created by ivan on 8/20/2017.
 */

public class ReviewWrapper {

    @Json(name = "results")
    private List<Review> reviews;

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
