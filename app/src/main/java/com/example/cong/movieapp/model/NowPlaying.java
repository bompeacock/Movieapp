package com.example.cong.movieapp.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by Cong on 14/10/2016.
 */

public class NowPlaying {
    @SerializedName("results")
    private List<Movie> movies;
    public List<Movie> getMovies(){
        return movies;
    }

}
