package com.example.guest.movieapp.models;

import android.media.Image;

public class Movie {
    private String mMovieName;
    private String mMovieImage;
    private String mMovieDescription;
    private double mMovieRating;

    public Movie(String movieName, String movieImage, String movieDescription, double movieRating) {

        this.mMovieName = movieName;
        this.mMovieImage = movieImage;
        this.mMovieDescription = movieDescription;
        this.mMovieRating = movieRating;
    }

    public String getMovieName() {

        return mMovieName;
    }

    public String getMovieImage() {

        return mMovieImage;
    }

    public String getMovieDescription () {

        return mMovieDescription;
    }

    public double getMovieRating() {
        return mMovieRating;
    }
}
