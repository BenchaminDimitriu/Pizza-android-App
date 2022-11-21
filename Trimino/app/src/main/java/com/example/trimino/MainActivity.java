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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                Intent k = new Intent(MainActivity.this, MainActivity.class);
                startActivity(k);
                return true;
            case R.id.item1:
                Toast.makeText(this, "Registration is selected", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, registration.class);
                startActivity(i);
                return true;
            case R.id.item2:
                Toast.makeText(this, "Login is selected", Toast.LENGTH_SHORT).show();
                Intent e = new Intent(MainActivity.this, login.class);
                startActivity(e);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}