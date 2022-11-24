package com.example.trimino;

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

public class menu extends AppCompatActivity {

    ImageView p1, p2, p3, p4;

    TextView userMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

//        p1 = findViewById(R.id.pizzaOne);
//        p2 = findViewById(R.id.pizzaTwo);
//        p3 = findViewById(R.id.pizzaThree);
//        p4 = findViewById(R.id.pizzaFour);

        userMenu = findViewById(R.id.menuUser);

        userMenu.setText(getIntent().getStringExtra("User"));

//        p1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = getIntent();
//                String menuUserID = i.getStringExtra("User");
//                Intent l = new Intent(menu.this, allDressed.class);
//                l.putExtra("User", menuUserID);
//                startActivity(l);
//            }
//        });
//
//        p2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = getIntent();
//                String menuUserID = i.getStringExtra("User");
//                Intent l = new Intent(menu.this, cheese.class);
//                l.putExtra("User", menuUserID);
//                startActivity(l);
//            }
//        });
//
//        p3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = getIntent();
//                String menuUserID = i.getStringExtra("User");
//                Intent l = new Intent(menu.this, threeCheese.class);
//                l.putExtra("User", menuUserID);
//                startActivity(l);
//            }
//        });
//
//        p4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = getIntent();
//                String menuUserID = i.getStringExtra("User");
//               Intent l = new Intent(menu.this, vegetable.class);
//                l.putExtra("User", menuUserID);
//                startActivity(l);
//            }
//        });

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
                Intent k = new Intent(menu.this, MainActivity.class);
                startActivity(k);
                return true;
            case R.id.profile:
                Toast.makeText(this, "Profile is selected", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(menu.this, profile.class);
                startActivity(i);
                return true;
            case R.id.menu:
                Toast.makeText(this, "Menu is selected", Toast.LENGTH_SHORT).show();
                Intent l = new Intent(menu.this, menu.class);
                startActivity(l);
                return true;
            case R.id.coupons:
                Toast.makeText(this, "Coupon is selected", Toast.LENGTH_SHORT).show();
                Intent e = new Intent(menu.this, coupons.class);
                startActivity(e);
                return true;
            case R.id.location:
                Toast.makeText(this, "Location is selected", Toast.LENGTH_SHORT).show();
                Intent a = new Intent(menu.this, location.class);
                startActivity(a);
                return true;
            case R.id.contact:
                Toast.makeText(this, "Contact is selected", Toast.LENGTH_SHORT).show();
                Intent b = new Intent(menu.this, contact.class);
                startActivity(b);
                return true;
            case R.id.cart:
                Toast.makeText(this, "Cart is selected", Toast.LENGTH_SHORT).show();
                Intent c = new Intent(menu.this, cart.class);
                startActivity(c);
                return true;
            case R.id.music:
                Toast.makeText(this, "Music is selected", Toast.LENGTH_SHORT).show();
                Intent f = new Intent(menu.this, musicController.class);
                startActivity(f);
                return true;
            case R.id.logout:
                Toast.makeText(this, "Logout is selected", Toast.LENGTH_SHORT).show();
                Intent d = new Intent(menu.this, login.class);
                startActivity(d);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}