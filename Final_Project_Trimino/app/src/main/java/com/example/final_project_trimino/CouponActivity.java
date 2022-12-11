package com.example.final_project_trimino;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CouponActivity extends AppCompatActivity {


    RecyclerViewAdapterCoupon adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon);

        ArrayList<String> codes = new ArrayList<>();
        codes.add("Coupon code: " + "co2aQ");
        codes.add("Coupon code: "+ "p3C0J");
        codes.add("Coupon code: "+ "K85zK");
        codes.add("Coupon code: "+ "77AMl");
        codes.add("Coupon code: "+ "sclQI");
        codes.add("Coupon code: "+ "r6k9a");

        ArrayList<String> title = new ArrayList<>();
        title.add("Kidz sale!");
        title.add("Christmas Sale!");
        title.add("Green Sale");
        title.add("Cheezy Sale");
        title.add("Carnivore Sale");
        title.add("Big pizza -> Smol sale");

        ArrayList<String> time = new ArrayList<>();
        time.add("Online only");
        time.add("Online only");
        time.add("Online only");
        time.add("Online only");
        time.add("Online only");
        time.add("Online only");

        ArrayList<String> description = new ArrayList<>();
        description.add("Save 3$ off a small pizza");
        description.add("Save 5% off your total purchase");
        description.add("Save 4$ on all vegetables toppings");
        description.add("Save 3$ off extra cheese topping");
        description.add("Save 2$ off a meat topping");
        description.add("Save 3$ off a large pizza");



        // set up the recyclerview
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapterCoupon( codes,title,time, description, CouponActivity.this);
        recyclerView.setAdapter(adapter);
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
                Intent k = new Intent(CouponActivity.this, MainActivity.class);
                startActivity(k);
                return true;
//            case R.id.profile:
//                Toast.makeText(this, "Profile is selected", Toast.LENGTH_SHORT).show();
//                Intent i = new Intent(MenuActivity.this, ProfileActivity.class);
//                startActivity(i);
//                return true;
            case R.id.menu:
                Toast.makeText(this, "Menu is selected", Toast.LENGTH_SHORT).show();
                Intent l = new Intent(CouponActivity.this, MenuActivity.class);
                startActivity(l);
                return true;
            case R.id.coupons:
                Toast.makeText(this, "Coupon is selected", Toast.LENGTH_SHORT).show();
                Intent e = new Intent(CouponActivity.this, CouponActivity.class);
                startActivity(e);
                return true;
            case R.id.location:
                Toast.makeText(this, "Location is selected", Toast.LENGTH_SHORT).show();
                Intent a = new Intent(CouponActivity.this, LocationActivity.class);
                startActivity(a);
                return true;
            case R.id.contact:
                Toast.makeText(this, "Contact is selected", Toast.LENGTH_SHORT).show();
                Intent b = new Intent(CouponActivity.this, ContactActivity.class);
                startActivity(b);
                return true;
            case R.id.cart:
                Toast.makeText(this, "Cart is selected", Toast.LENGTH_SHORT).show();
                Intent c = new Intent(CouponActivity.this, CartActivity.class);
                startActivity(c);
                return true;
            case R.id.music:
                Toast.makeText(this, "Music is selected", Toast.LENGTH_SHORT).show();
                Intent f = new Intent(CouponActivity.this, MusicActivity.class);
                startActivity(f);
                return true;
            case R.id.logout:
                Toast.makeText(this, "Logout is selected", Toast.LENGTH_SHORT).show();
                Intent d = new Intent(CouponActivity.this, LoginActivity.class);
                startActivity(d);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}