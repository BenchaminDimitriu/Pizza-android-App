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

public class login extends AppCompatActivity {

    EditText userID, password;
    Button login, registration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        userID = findViewById(R.id.userID);
        password = findViewById(R.id.password);
        login = findViewById(R.id.loginBtn);
        registration = findViewById(R.id.loginRegistrationBtn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = getIntent();
                String loginUserID = i.getStringExtra("User");
                String loginPass = i.getStringExtra("Pass");
                if(userID.getText().toString().equals(loginUserID) && password.getText().toString().equals(loginPass)){
                    Intent l = new Intent(login.this, menu.class);
                    l.putExtra("User", loginUserID);
                    startActivity(l);
                }else Toast.makeText(getApplicationContext(), "Enter a valid UserID and Password", Toast.LENGTH_SHORT).show();
            }
        });

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent v = new Intent(login.this, registration.class);
                startActivity(v);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.item:
                Toast.makeText(this, "Home is selected", Toast.LENGTH_SHORT).show();
                Intent k = new Intent(login.this, MainActivity.class);
                startActivity(k);
                return true;
            case R.id.item1:
                Toast.makeText(this, "Registration is selected", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(login.this, registration.class);
                startActivity(i);
                return true;
            case R.id.item2:
                Toast.makeText(this, "Login is selected", Toast.LENGTH_SHORT).show();
                Intent e = new Intent(login.this, login.class);
                startActivity(e);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}