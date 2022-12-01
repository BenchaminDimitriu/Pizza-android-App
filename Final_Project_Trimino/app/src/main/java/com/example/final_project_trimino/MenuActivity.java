package com.example.final_project_trimino;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {


    ImageView p1, p2, p3, p4;

    TextView userMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        p1 = findViewById(R.id.hawaiianPizzaPic);
        p2 = findViewById(R.id.pepperoniPizzaPic);
        p3 = findViewById(R.id.mexicanPizzaPic);
        p4 = findViewById(R.id.cheesePizzaPic);

        //userMenu = findViewById(R.id.menuUser);

        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = getIntent();
                String menuUserID = i.getStringExtra("User");
                Intent l = new Intent(MenuActivity.this, hawaiian.class);
                l.putExtra("User", menuUserID);
                startActivity(l);
            }
        });

        p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = getIntent();
                String menuUserID = i.getStringExtra("User");
                Intent l = new Intent(MenuActivity.this, pepperoni.class);
                l.putExtra("User", menuUserID);
                startActivity(l);
            }
        });

        p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = getIntent();
                String menuUserID = i.getStringExtra("User");
                Intent l = new Intent(MenuActivity.this, mexican.class);
                l.putExtra("User", menuUserID);
                startActivity(l);
            }
        });

        p4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = getIntent();
                String menuUserID = i.getStringExtra("User");
                Intent l = new Intent(MenuActivity.this, cheese.class);
                l.putExtra("User", menuUserID);
                startActivity(l);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.second_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.home:
                Toast.makeText(this, "Home is selected", Toast.LENGTH_SHORT).show();
                Intent k = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(k);
                return true;
//            case R.id.profile:
//                Toast.makeText(this, "Profile is selected", Toast.LENGTH_SHORT).show();
//                Intent i = new Intent(MenuActivity.this, ProfileActivity.class);
//                startActivity(i);
//                return true;
            case R.id.menu:
                Toast.makeText(this, "Menu is selected", Toast.LENGTH_SHORT).show();
                Intent l = new Intent(MenuActivity.this, MenuActivity.class);
                startActivity(l);
                return true;
            case R.id.coupons:
                Toast.makeText(this, "Coupon is selected", Toast.LENGTH_SHORT).show();
                Intent e = new Intent(MenuActivity.this, CouponActivity.class);
                startActivity(e);
                return true;
            case R.id.location:
                Toast.makeText(this, "Location is selected", Toast.LENGTH_SHORT).show();
                Intent a = new Intent(MenuActivity.this, LocationActivity.class);
                startActivity(a);
                return true;
            case R.id.contact:
                Toast.makeText(this, "Contact is selected", Toast.LENGTH_SHORT).show();
                Intent b = new Intent(MenuActivity.this, ContactActivity.class);
                startActivity(b);
                return true;
            case R.id.cart:
                Toast.makeText(this, "Cart is selected", Toast.LENGTH_SHORT).show();
                Intent c = new Intent(MenuActivity.this, CartActivity.class);
                startActivity(c);
                return true;
            case R.id.music:
                Toast.makeText(this, "Music is selected", Toast.LENGTH_SHORT).show();
                Intent f = new Intent(MenuActivity.this, MusicActivity.class);
                startActivity(f);
                return true;
            case R.id.logout:
                Toast.makeText(this, "Logout is selected", Toast.LENGTH_SHORT).show();
                Intent d = new Intent(MenuActivity.this, LoginActivity.class);
                startActivity(d);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}