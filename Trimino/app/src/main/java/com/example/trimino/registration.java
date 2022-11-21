package com.example.trimino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registration extends AppCompatActivity {

    EditText regisUser, regisPass, regisCon;
    Button regisBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        regisUser = findViewById(R.id.registrationUserID);
        regisPass = findViewById(R.id.registrationPassword);
        regisCon = findViewById(R.id.confirmPassword);

        regisBtn = findViewById(R.id.registrationBtn);

        regisBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rUser = regisUser.getText().toString();
                String rPass = regisPass.getText().toString();
                String rCon = regisCon.getText().toString();
                if(rPass.equals(rCon)){
                    Intent i = new Intent(registration.this, MainActivity.class);
                    i.putExtra("User", rUser);
                    i.putExtra("Pass", rPass);
                    startActivity(i);
                }else Toast.makeText(registration.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            }
        });
    }
}