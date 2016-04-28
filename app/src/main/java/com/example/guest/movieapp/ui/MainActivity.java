package com.example.guest.movieapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.guest.movieapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.submitButton) Button mSubmitButton;
    @Bind(R.id.movieSearchEditText) EditText mMovieSearchEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String movieName = mMovieSearchEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this, ResultsActivity.class);
                intent.putExtra("movieName", movieName);
                startActivity(intent);
            }
        });

    }
}
