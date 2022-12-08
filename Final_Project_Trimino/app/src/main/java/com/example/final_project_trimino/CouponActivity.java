package com.example.final_project_trimino;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class CouponActivity extends AppCompatActivity {


    RecyclerViewAdapterCoupon adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon);

        ArrayList<String> codes = new ArrayList<>();
        codes.add("Coupon code: " + "Qts98");
        codes.add("Coupon code: " + "e59lR");
        codes.add("Coupon code: " + "bM3BX");
        codes.add("Coupon code: " + "OFxvT");
        codes.add("Coupon code: " + "cJj0E");
        codes.add("Coupon code: " + "rFZnI");

        ArrayList<String> title = new ArrayList<>();
        title.add("Saturday Sale");
        title.add("Monthly Sale");
        title.add("Top(ping) hat sale Only");
        title.add("Cheesy Sale");
        title.add("Free Medium Size Pizza");
        title.add("Veggie Topping Sale");

        ArrayList<String> time = new ArrayList<>();
        time.add("Online only");
        time.add("Online only");
        time.add("Online only");
        time.add("Online only");
        time.add("Online only");
        time.add("Online only");

        ArrayList<String> description = new ArrayList<>();
        description.add("Save 2$ off from toppings");
        description.add("Save 5$ off topping when buying more than one pizza");
        description.add("Save 4$ off the small pizza");
        description.add("Save money of the extra cheese topping");
        description.add("Free medium size pizza (require 3 toppings)");
        description.add("Save 5$ off vegetables topping pizza (require vegetable toppings)");



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