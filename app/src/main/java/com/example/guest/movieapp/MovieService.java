package com.example.guest.movieapp;

import android.util.Log;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class MovieService {

    public static void findMovies(String movieName, Callback callback) {
        String API_Key = Constants.MOVIE_KEY;

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.MOVIE_TITLE_SEARCH_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.MOVIE_TITLE_QUERY_PARAMETER, movieName);
        urlBuilder.addQueryParameter("api_key", API_Key);
        String url = urlBuilder.build().toString();
        Log.d("url-log",url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
