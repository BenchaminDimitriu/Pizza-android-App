package com.example.trimino;

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

public class coupons extends AppCompatActivity {

    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupons);

        ArrayList<String> codes = new ArrayList<>();
        codes.add("Coupon code: ");
        codes.add("Coupon code: ");
        codes.add("Coupon code: ");
        codes.add("Coupon code: ");
        codes.add("Coupon code: ");
        codes.add("Coupon code: ");

        ArrayList<String> title = new ArrayList<>();
        title.add("Get 1 10’ pizza for 10$");
        title.add("Get 10% off all toppings");
        title.add("Get 20% off all toppings");
        title.add("Get 1 12’ pizza for 12$");
        title.add("Get 1 18’ pizza for 14$");
        title.add("Get 1 18’ pizza for 14$");

        ArrayList<String> time = new ArrayList<>();
        time.add("Online only");
        time.add("Online only");
        time.add("Online only");
        time.add("Online only");
        time.add("Online only");
        time.add("Online only");

        ArrayList<String> description = new ArrayList<>();
        description.add("Save 2$ off a small pizza");
        description.add("Save 10% on all your toppings");
        description.add("Save 20% on all your toppings");
        description.add("Save 2$ off a medium pizza");
        description.add("Save 2$ off a large pizza");
        description.add("Save 2$ off a large pizza");



        // set up the recyclerview
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter( codes,title,time, description, coupons.this);
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
            case R.id.item:
                Toast.makeText(this, "Home is selected", Toast.LENGTH_SHORT).show();
                Intent k = new Intent(coupons.this, MainActivity.class);
                startActivity(k);
                return true;
            case R.id.item1:
                Toast.makeText(this, "Profile is selected", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(coupons.this, profile.class);
                startActivity(i);
                return true;
            case R.id.menu:
                Toast.makeText(this, "Menu is selected", Toast.LENGTH_SHORT).show();
                Intent l = new Intent(coupons.this, menu.class);
                startActivity(l);
                return true;
            case R.id.item2:
                Toast.makeText(this, "Coupon is selected", Toast.LENGTH_SHORT).show();
                Intent e = new Intent(coupons.this, coupons.class);
                startActivity(e);
                return true;
            case R.id.item3:
                Toast.makeText(this, "Location is selected", Toast.LENGTH_SHORT).show();
                Intent a = new Intent(coupons.this, location.class);
                startActivity(a);
                return true;
            case R.id.item4:
                Toast.makeText(this, "Contact is selected", Toast.LENGTH_SHORT).show();
                Intent b = new Intent(coupons.this, contact.class);
                startActivity(b);
                return true;
            case R.id.item5:
                Toast.makeText(this, "Cart is selected", Toast.LENGTH_SHORT).show();
                Intent c = new Intent(coupons.this, cart.class);
                startActivity(c);
                return true;
            case R.id.item6:
                Toast.makeText(this, "Logout is selected", Toast.LENGTH_SHORT).show();
                Intent d = new Intent(coupons.this, login.class);
                startActivity(d);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}