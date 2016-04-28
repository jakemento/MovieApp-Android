package com.example.guest.movieapp.services;

import android.util.Log;

import com.example.guest.movieapp.Constants;
import com.example.guest.movieapp.models.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MovieService {

    public static void findMovies(String movieName, Callback callback) {
        String API_Key = Constants.MOVIE_KEY;

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.MOVIE_TITLE_SEARCH_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.MOVIE_TITLE_QUERY_PARAMETER, movieName);
        urlBuilder.addQueryParameter("api_key", API_Key);
        String url = urlBuilder.build().toString();
        Log.d("url-log", url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public static ArrayList<Movie> processResults(Response response) {
        ArrayList<Movie> movies = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject movieJSON = new JSONObject(jsonData);
                JSONArray moviesJSON = movieJSON.getJSONArray("results");
                for (int i = 0; i < moviesJSON.length(); i++) {
                    JSONObject filmJSON = moviesJSON.getJSONObject(i);
                    String name = filmJSON.getString("title");

                    Movie movie = new Movie(name);
                    movies.add(movie);

                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return movies;
    }
}