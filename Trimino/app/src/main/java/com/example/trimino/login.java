package com.example.trimino;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class login extends AppCompatActivity {

    EditText username, password;
    Button loginBtn, regisBtn;

    String uName;
    String uPass;

    DatabaseReference ref;
    ArrayList<String> arrayList = new ArrayList<>();
    FirebaseAuth mAuth;

    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        username = findViewById(R.id.userID);
        password = findViewById(R.id.password);

        loginBtn = findViewById(R.id.loginBtn);
        regisBtn = findViewById(R.id.loginRegistrationBtn);

        //mAuth = FirebaseAuth.getInstance();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref = FirebaseDatabase.getInstance().getReference().child("User").child("1");
                //ref = FirebaseDatabase.getInstance().getReference().child("User").child(name);
                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        uName = snapshot.child("username").getValue().toString().trim();
                        uPass = snapshot.child("password").getValue().toString().trim();

                        if(uName.equals(username.getText().toString().trim()) && uPass.equals(password.getText().toString().trim())){
                            Toast.makeText(login.this, "Login successful", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(getApplicationContext(), menu.class);
                            startActivity(i);
                        }
                        else{
                            Toast.makeText(login.this, "Login failed", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        regisBtn.setOnClickListener(new View.OnClickListener() {
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
            case R.id.home:
                Toast.makeText(this, "Home is selected", Toast.LENGTH_SHORT).show();
                Intent k = new Intent(login.this, MainActivity.class);
                startActivity(k);
                return true;
            case R.id.register:
                Toast.makeText(this, "Registration is selected", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(login.this, registration.class);
                startActivity(i);
                return true;
            case R.id.login:
                Toast.makeText(this, "Login is selected", Toast.LENGTH_SHORT).show();
                Intent e = new Intent(login.this, login.class);
                startActivity(e);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}