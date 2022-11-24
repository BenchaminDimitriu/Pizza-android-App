package com.example.trimino;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class contact extends AppCompatActivity {

    FloatingActionButton mHome, mFacebook, mTwit;
    TextView fbText, twitText;

    Boolean isAllfabsvisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        mHome = findViewById(R.id.homeFloatBtn);
        mFacebook = findViewById(R.id.fbFloatBtn);
        mTwit = findViewById(R.id.twitFloatBtn);

        fbText = findViewById(R.id.fb);
        twitText = findViewById(R.id.twitter);

        mFacebook.setVisibility(View.GONE);
        mTwit.setVisibility(View.GONE);
        fbText.setVisibility(View.GONE);
        twitText.setVisibility(View.GONE);

        isAllfabsvisible = false;

        mHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isAllfabsvisible){
                    mFacebook.setVisibility(View.VISIBLE);
                    mTwit.setVisibility(View.VISIBLE);
                    fbText.setVisibility(View.VISIBLE);
                    twitText.setVisibility(View.VISIBLE);
                    isAllfabsvisible = true;
                }else{
                    mFacebook.setVisibility(View.GONE);
                    mTwit.setVisibility(View.GONE);
                    fbText.setVisibility(View.GONE);
                    twitText.setVisibility(View.GONE);

                    isAllfabsvisible = false;
                }

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
                Intent k = new Intent(contact.this, MainActivity.class);
                startActivity(k);
                return true;
            case R.id.profile:
                Toast.makeText(this, "Profile is selected", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(contact.this, profile.class);
                startActivity(i);
                return true;
            case R.id.menu:
                Toast.makeText(this, "Menu is selected", Toast.LENGTH_SHORT).show();
                Intent l = new Intent(contact.this, menu.class);
                startActivity(l);
                return true;
            case R.id.coupons:
                Toast.makeText(this, "Coupon is selected", Toast.LENGTH_SHORT).show();
                Intent e = new Intent(contact.this, coupons.class);
                startActivity(e);
                return true;
            case R.id.location:
                Toast.makeText(this, "Location is selected", Toast.LENGTH_SHORT).show();
                Intent a = new Intent(contact.this, location.class);
                startActivity(a);
                return true;
            case R.id.contact:
                Toast.makeText(this, "Contact is selected", Toast.LENGTH_SHORT).show();
                Intent b = new Intent(contact.this, contact.class);
                startActivity(b);
                return true;
            case R.id.cart:
                Toast.makeText(this, "Cart is selected", Toast.LENGTH_SHORT).show();
                Intent c = new Intent(contact.this, cart.class);
                startActivity(c);
                return true;
            case R.id.music:
                Toast.makeText(this, "Music is selected", Toast.LENGTH_SHORT).show();
                Intent f = new Intent(contact.this, musicController.class);
                startActivity(f);
                return true;
            case R.id.logout:
                Toast.makeText(this, "Logout is selected", Toast.LENGTH_SHORT).show();
                Intent d = new Intent(contact.this, login.class);
                startActivity(d);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}