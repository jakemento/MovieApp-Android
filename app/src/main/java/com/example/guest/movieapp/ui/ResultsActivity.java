package com.example.guest.movieapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.guest.movieapp.services.MovieService;
import com.example.guest.movieapp.R;
import com.example.guest.movieapp.models.Movie;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ResultsActivity extends AppCompatActivity {
    public ArrayList<Movie> mMovies = new ArrayList<>();
    public static final String TAG = ResultsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String movieName = intent.getStringExtra("movieName");
        Log.d("movieName log", movieName);
        getMovies(movieName);
    }

    private void getMovies(String movieName) {
        MovieService.findMovies(movieName, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();

            }

            @Override
            public void onResponse(Call call, Response response) {
                mMovies = MovieService.processResults(response);
                ResultsActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String[] movieNames = new String[mMovies.size()];
                        for (int i = 0; i < movieNames.length; i++) {
                            movieNames[i] = mMovies.get(i).getMovieName();
                        }
                        ArrayAdapter adapter = new ArrayAdapter(ResultsActivity.this, android.R.layout.simple_list_item_1, movieNames);
                        mListView.setAdapter(adapter);

                        for (Movie movie : mMovies) {
                            Log.d(TAG, "Title " + movie.getMovieName());
                        }
                    }
                });

            }
        });
    }
}