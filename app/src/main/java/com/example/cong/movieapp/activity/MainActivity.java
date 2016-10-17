package com.example.cong.movieapp.activity;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.cong.movieapp.R;
import com.example.cong.movieapp.adapter.MovieAdapter;
import com.example.cong.movieapp.api.MovieApi;

import com.example.cong.movieapp.model.Movie;
import com.example.cong.movieapp.model.NowPlaying;
import com.example.cong.movieapp.untils.RetrofitUntils;

import java.io.Serializable;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ListView lvMovie;
    private MovieApi mMovieApi;
    private ProgressBar pbload;
    ArrayList<Movie> listMovie;
    private SwipeRefreshLayout refresh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();

        fetchMovies();

    }
    private void addEvents() {
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fetchMovies();

            }
        });

        lvMovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,DetailsMovieActivity.class);
                intent.putExtra("movie", listMovie.get(i));
                startActivity(intent);
            }
        });
    }

    private void addControls() {
        mMovieApi = RetrofitUntils.get().create(MovieApi.class);
        lvMovie = (ListView) findViewById(R.id.lvMovie);
        pbload = (ProgressBar) findViewById(R.id.pbload);
        refresh = (SwipeRefreshLayout) findViewById(R.id.refresh);




    }

    private void fetchMovies() {
        mMovieApi.getNowPlaying().enqueue(new Callback<NowPlaying>() {
            @Override
            public void onResponse(Call<NowPlaying> call, Response<NowPlaying> response) {
                handleResponse(response);
            }
            @Override
            public void onFailure(Call<NowPlaying> call, Throwable t) {
                Log.e("Error",t.getMessage());
            }
        });
    }

    private void handleResponse(Response<NowPlaying> response) {
        listMovie = (ArrayList<Movie>) response.body().getMovies();
        lvMovie.setAdapter(new MovieAdapter(this,listMovie));
        refresh.setRefreshing(false);
        pbload.setVisibility(View.GONE);

    }
}

// where you here
//top
// i don;t  mark debug

