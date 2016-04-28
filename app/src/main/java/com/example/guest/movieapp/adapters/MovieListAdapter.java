package com.example.guest.movieapp.adapters;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guest.movieapp.R;
import com.example.guest.movieapp.models.Movie;
import com.example.guest.movieapp.ui.MovieDetailActivity;
import com.example.guest.movieapp.ui.ResultsListActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 4/28/16.
 */
public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {
    private ArrayList<Movie> mMovies = new ArrayList<>();
    private Context mContext;

    public MovieListAdapter(Context context, ArrayList<Movie> movies) {
        mContext = context;
        mMovies = movies;
    }
    @Override
    public MovieListAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item, parent, false);

        MovieViewHolder viewHolder = new MovieViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(MovieListAdapter.MovieViewHolder holder, int position) {
        holder.bindMovie(mMovies.get(position));
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }


    public class MovieViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.movieImageView) ImageView mMovieImageView;
        @Bind(R.id.movieNameTextView) TextView mNameTextView;
//        @Bind(R.id.descriptionTextView) TextView mDescriptionTextView;
        @Bind(R.id.ratingTextView) TextView mRatingTextView;
        @Bind(R.id.releaseDateTextView) TextView mReleaseDate;
        private Context mContext;

        public MovieViewHolder (View itemView) {
            super(itemView);
            mContext = itemView.getContext();
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int itemPosition = getLayoutPosition();
                    Intent intent = new Intent (mContext, MovieDetailActivity.class);
                    intent.putExtra("position", itemPosition + "");
                    intent.putExtra("movies", Parcels.wrap(mMovies));
                    mContext.startActivity(intent);
                }
            });
        }

        public void bindMovie(Movie movie) {
            Picasso.with(mContext).load(movie.getMovieImage()).into(mMovieImageView);
            mNameTextView.setText(movie.getMovieName());
//            mDescriptionTextView.setText(movie.getMovieDescription());
            mRatingTextView.setText(movie.getMovieRating());
            mReleaseDate.setText(movie.getReleaseDate());
        }
    }
}