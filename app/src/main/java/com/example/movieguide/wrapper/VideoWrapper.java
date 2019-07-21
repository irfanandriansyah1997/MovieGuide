package com.example.movieguide.wrapper;

import com.example.movieguide.model.Video;
import com.squareup.moshi.Json;
import java.util.List;

/**
 * @author Irfan Andriansyah
 */
public class VideoWrapper {

    @Json(name = "results")
    private List<Video> videos;

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

}
