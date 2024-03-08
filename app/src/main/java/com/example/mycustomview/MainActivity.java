package com.example.mycustomview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SimpleProgressBar progressBar = findViewById(R.id.simpleProgressBar);
        Button startButton = findViewById(R.id.startButton);
        Button clearButton = findViewById(R.id.clearButton);

        startButton.setOnClickListener(v -> {
            progressBar.setProgress(progressBar.getProgress() + 10); // 기존 진행률에 10만큼 추가
        });

        clearButton.setOnClickListener(v ->{
            progressBar.setProgress(0);
        });

        //progressBar.setProgress(10); // 초기 진행상태 설정
    }
}