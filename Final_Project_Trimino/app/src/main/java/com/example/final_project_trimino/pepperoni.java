package com.example.final_project_trimino;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class pepperoni extends AppCompatActivity {


    CheckBox olives, mushrooms, peppers, onions, bacons, pineapples, excheese, small, medium, large;
    Button totalBtn;
    EditText total;
    int cost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pepperoni);

        olives = findViewById(R.id.olivesBox);
        mushrooms = findViewById(R.id.mushroomsBox);
        peppers = findViewById(R.id.peppersBox);
        onions = findViewById(R.id.onionsBox);
        bacons =  findViewById(R.id.baconBitsBox);
        pineapples = findViewById(R.id.pineapplesBox);
        excheese = findViewById(R.id.extraCheeseBox);

        small = findViewById(R.id.smallPizza);
        medium = findViewById(R.id.mediumPizza);
        large = findViewById(R.id.largePizza);

        totalBtn = findViewById(R.id.totalBtn);
        total = findViewById(R.id.pepperoniTotal);

        totalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(olives.isChecked()){
                    cost += 2;
                } if(mushrooms.isChecked()){
                    cost += 4;
                } if(peppers.isChecked()){
                    cost += 3;
                } if(onions.isChecked()){
                    cost += 2;
                } if(bacons.isChecked()){
                    cost += 4;
                } if(pineapples.isChecked()){
                    cost += 3;
                } if(excheese.isChecked()){
                    cost += 4;
                } if(small.isChecked()){
                    cost += 10;
                } if(medium.isChecked()){
                    cost += 12;
                } if(large.isChecked()){
                    cost += 14;
                } if (small.isChecked() && medium.isChecked()){
                    Toast.makeText(pepperoni.this, "Only one size can picked", Toast.LENGTH_SHORT).show();
                    cost =0;
                } if (small.isChecked() && large.isChecked()){
                    Toast.makeText(pepperoni.this, "Only one size can picked", Toast.LENGTH_SHORT).show();
                    cost =0;
                } if (medium.isChecked() && large.isChecked()){
                    Toast.makeText(pepperoni.this, "Only one size can picked", Toast.LENGTH_SHORT).show();
                    cost =0;
                } if (small.isChecked() && medium.isChecked()){
                    Toast.makeText(pepperoni.this, "Only one size can picked", Toast.LENGTH_SHORT).show();
                    cost =0;
                } if (medium.isChecked() && large.isChecked()){
                    Toast.makeText(pepperoni.this, "Only one size can picked", Toast.LENGTH_SHORT).show();
                    cost =0;
                } if (small.isChecked() && medium.isChecked() && large.isChecked()){
                    Toast.makeText(pepperoni.this, "Only one size can picked", Toast.LENGTH_SHORT).show();
                    cost =0;
                }
                total.setText("Total Price: $"+String.valueOf(cost));
                cost =0;
            }
        });
    }
}