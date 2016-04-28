package com.example.guest.movieapp.models;

import android.media.Image;

public class Movie {
    private String mMovieName;
    private String mMovieImage;
    private String mMovieDescription;
    private String mMovieRating;
    private String mReleaseDate;

    public Movie(String movieName, String movieImage, String movieDescription, String movieRating, String releaseDate) {

        this.mMovieName = movieName;
        this.mMovieImage = "http://image.tmdb.org/t/p/w500/" +movieImage;
        this.mMovieDescription = movieDescription;
        this.mMovieRating = movieRating;
        this.mReleaseDate = releaseDate;
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

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public String getMovieRating() {
        return mMovieRating;
    }
}
