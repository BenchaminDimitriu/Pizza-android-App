package com.example.trimino;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registration extends AppCompatActivity {

    EditText regisUser, regisPass, regisCon;
    Button regisBtn;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

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
                    Intent i = new Intent(registration.this, login.class);
                    i.putExtra("User", rUser);
                    i.putExtra("Pass", rPass);
                    startActivity(i);
                }else Toast.makeText(registration.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.item:
                Toast.makeText(this, "Home is selected", Toast.LENGTH_SHORT).show();
                Intent k = new Intent(registration.this, MainActivity.class);
                startActivity(k);
                return true;
            case R.id.item1:
                Toast.makeText(this, "Registration is selected", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(registration.this, registration.class);
                startActivity(i);
                return true;
            case R.id.item2:
                Toast.makeText(this, "Login is selected", Toast.LENGTH_SHORT).show();
                Intent e = new Intent(registration.this, login.class);
                startActivity(e);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}