package com.example.cong.movieapp.adapter;

import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.cong.movieapp.R;
import com.example.cong.movieapp.model.Movie;

import java.util.List;

/**
 * Created by Cong on 15/10/2016.
 */

public class MovieAdapter extends ArrayAdapter<Movie> {

    public MovieAdapter(Context context, List<Movie> movies) {
        super(context,R.layout.item_movie,movies);

    }




    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Viewholder viewholder;
        Movie movie = getItem(position);
        if(convertView==null){
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(R.layout.item_movie, parent, false);

            viewholder = new Viewholder();
            viewholder.txtTitle = (TextView) convertView.findViewById(R.id.txtTitle);
            viewholder.txtOverview  = (TextView) convertView.findViewById(R.id.txtOverview);
            viewholder.txtDate = (TextView) convertView.findViewById(R.id.txtDate);
            viewholder.ivCover = (ImageView) convertView.findViewById(R.id.ivCover);
            convertView.setTag(viewholder);
        }else{
            viewholder = (Viewholder) convertView.getTag();
        }




        //fill data
        viewholder.txtTitle.setText(movie.getTitle());
        viewholder.txtOverview.setText(movie.getOverview());
        viewholder.txtDate.setText(movie.getReleaseDate());
        Configuration configuration = getContext().getResources().getConfiguration();
        if(configuration.orientation==Configuration.ORIENTATION_PORTRAIT){
            Glide.with(getContext())
                    .load(movie.getPosterPath())
                    .placeholder(R.drawable.playhoder)
                    .into(viewholder.ivCover);
        }else{
            Glide.with(getContext())
                    .load(movie.getBackdropPath())
                    .placeholder(R.drawable.playhoder)
                    .into(viewholder.ivCover);

        }
        return convertView;

    }
    public class Viewholder{
        private TextView txtTitle;
        private TextView txtOverview;
        private ImageView ivCover;
        private TextView txtDate;
    }
}
