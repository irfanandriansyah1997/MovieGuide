package com.example.movieguide.module;

/**
 * @author Irfan Andriansyah
 */
public class APIModules {
    public static final String BASE_POSTER_PATH = "http://image.tmdb.org/t/p/w342";
    public static final String BASR_BACKDROP_PATH = "http://image.tmdb.org/t/p/w780";
    public static final String YOUTUBE_VIDEO_URL = "http://www.youtube.com/watch?v=%1$s";
    public static final String YOUTUBE_THUMBNAIL_URL = "http://img.youtube.com/vi/%1$s/0.jpg";


    public static String getPosterPath(String posterPath) {
        return BASE_POSTER_PATH + posterPath;
    }

    public static String getBackdropPath(String backdropPath) {
        return BASR_BACKDROP_PATH + backdropPath;
    }
}
