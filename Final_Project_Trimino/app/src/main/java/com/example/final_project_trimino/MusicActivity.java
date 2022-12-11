package com.example.final_project_trimino;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MusicActivity extends AppCompatActivity {


    //MediaPlayer MusicPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        Intent getSong = getIntent();
        int resume = getSong.getIntExtra("song", 0);
    }


    public void stop(View view) {
//        stopPlayer();
        MusicPlayer.stopAudio(this);
    }

    public void play(View view) {
//        playMusic();
        MusicPlayer.playAudio(this);
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
                Intent k = new Intent(MusicActivity.this, MainActivity.class);
                startActivity(k);
                return true;
            case R.id.menu:
                Toast.makeText(this, "Menu is selected", Toast.LENGTH_SHORT).show();
                Intent l = new Intent(MusicActivity.this, MenuActivity.class);
                startActivity(l);
                return true;
            case R.id.coupons:
                Toast.makeText(this, "Coupon is selected", Toast.LENGTH_SHORT).show();
                Intent e = new Intent(MusicActivity.this, CouponActivity.class);
                startActivity(e);
                return true;
            case R.id.location:
                Toast.makeText(this, "Location is selected", Toast.LENGTH_SHORT).show();
                Intent a = new Intent(MusicActivity.this, LocationActivity.class);
                startActivity(a);
                return true;
            case R.id.contact:
                Toast.makeText(this, "Contact is selected", Toast.LENGTH_SHORT).show();
                Intent b = new Intent(MusicActivity.this, ContactActivity.class);
                startActivity(b);
                return true;
            case R.id.cart:
                Toast.makeText(this, "Cart is selected", Toast.LENGTH_SHORT).show();
                Intent c = new Intent(MusicActivity.this, CartActivity.class);
                startActivity(c);
                return true;
            case R.id.music:
                Toast.makeText(this, "Music is selected", Toast.LENGTH_SHORT).show();
                Intent f = new Intent(MusicActivity.this, MusicActivity.class);
                startActivity(f);
                return true;
            case R.id.logout:
                Toast.makeText(this, "Logout is selected", Toast.LENGTH_SHORT).show();
                Intent d = new Intent(MusicActivity.this, LoginActivity.class);
                startActivity(d);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
//    private void stopPlayer() {
//        if(player != null){
//            player.release();
//            player = null;
//            Toast.makeText(this,"MediaPlayer source is released", Toast.LENGTH_SHORT).show();
//        }
//    }
}