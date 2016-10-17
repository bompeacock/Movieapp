package com.example.cong.movieapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.cong.movieapp.R;
import com.example.cong.movieapp.model.Movie;
import com.example.cong.movieapp.untils.Constant;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeThumbnailView;

public class DetailsMovieActivity extends AppCompatActivity {
    TextView popularing,rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_movie);

        addControls();
        addEvents();

        Intent intent = getIntent();
        Movie movie = (Movie) intent.getSerializableExtra("movie");
        popularing.setText("Popularing: "+movie.getPopularity());
        rating.setText(movie.getVoteAverage());
    }

    private void addEvents() {

    }

    private void addControls() {
        popularing = (TextView) findViewById(R.id.txtPopularing);
        rating = (TextView) findViewById(R.id.txtRating);
    }
}
