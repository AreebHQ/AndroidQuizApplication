package com.example.practiceone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Stats extends AppCompatActivity {
    TextView money,score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        score = findViewById(R.id.score);
        money = findViewById(R.id.money);

        // Receiving intent from MainActivity and setting data in this activity
        Intent receiverIntent = getIntent();
        int correct = receiverIntent.getIntExtra( "correct",0);
        int wrong = receiverIntent.getIntExtra( "wrong",0);
        int amount = receiverIntent.getIntExtra("amount", 0);
        score.setText("Correct: "+ correct + " Wrong : " + wrong);
        money.setText(String.valueOf(amount));


    }
}