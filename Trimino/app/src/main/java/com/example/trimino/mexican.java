package com.example.trimino;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class mexican extends AppCompatActivity {


    CheckBox olives, mushrooms, peppers, onions, bacons, pineapples, excheese;
    Button totalBtn;
    EditText total;
    int cost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mexican);

        olives = findViewById(R.id.olivesBox);
        mushrooms = findViewById(R.id.mushroomsBox);
        peppers = findViewById(R.id.peppersBox);
        onions = findViewById(R.id.onionsBox);
        bacons =  findViewById(R.id.baconBitsBox);
        pineapples = findViewById(R.id.pineapplesBox);
        excheese = findViewById(R.id.extraCheeseBox);

        totalBtn = findViewById(R.id.totalBtn);
        total = findViewById(R.id.mexicanTotal);

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
                }
                total.setText("Total Price: $"+String.valueOf(cost));
                cost =0;
            }
        });
    }
}