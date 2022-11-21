package com.example.trimino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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

        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = getIntent();
                String menuUserID = i.getStringExtra("User");
             //   Intent l = new Intent(menu.this, allDressed.class);
//                l.putExtra("User", menuUserID);
//                startActivity(l);
            }
        });

        p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = getIntent();
                String menuUserID = i.getStringExtra("User");
               // Intent l = new Intent(menu.this, cheese.class);
//                l.putExtra("User", menuUserID);
//                startActivity(l);
            }
        });

        p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = getIntent();
                String menuUserID = i.getStringExtra("User");
              //  Intent l = new Intent(menu.this, threeCheese.class);
//                l.putExtra("User", menuUserID);
//                startActivity(l);
            }
        });

        p4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = getIntent();
                String menuUserID = i.getStringExtra("User");
              // Intent l = new Intent(menu.this, vegetable.class);
//                l.putExtra("User", menuUserID);
//                startActivity(l);
            }
        });

    }
}