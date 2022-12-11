package com.example.final_project_trimino;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

public class CheckoutActivity extends AppCompatActivity {

    ProgressBar progressBar;
    int progressStatus = 0;
    TextView textView;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        progressBar = findViewById(R.id.progressBar);
        textView = findViewById(R.id.textView2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(progressStatus < 100){
                    progressStatus += 2;

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progressStatus);
                            if(progressStatus == 100){
                                textView.setText("Your order is arrived!");
                            }
                        }
                    });
                    try {
                        Thread.sleep(200);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}