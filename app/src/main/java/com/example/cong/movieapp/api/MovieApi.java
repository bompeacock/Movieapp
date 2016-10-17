package com.example.cong.movieapp.api;

import com.example.cong.movieapp.model.ListTrailer;
import com.example.cong.movieapp.model.NowPlaying;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Cong on 14/10/2016.
 */

public interface MovieApi {
    @GET("now_playing")
    Call<NowPlaying> getNowPlaying();
    @GET("{id}/videos")
    Call<ListTrailer> getTrailer(@Path("id") String id);


}
