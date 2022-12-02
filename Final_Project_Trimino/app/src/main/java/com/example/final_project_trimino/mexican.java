package com.example.final_project_trimino;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.android.material.slider.Slider;

public class mexican extends AppCompatActivity {

    Slider sizeSlider;
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
        sizeSlider = findViewById(R.id.slider);

        totalBtn = findViewById(R.id.totalBtn);
        total = findViewById(R.id.mexicanTotal);

        totalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sizeSlider.getValue()==0){
                    cost += 6;
                }
                if(sizeSlider.getValue()==1){
                    cost += 8;
                }
                if(sizeSlider.getValue()==2){
                    cost += 11;
                }
                if(sizeSlider.getValue()==3){
                    cost += 14;
                }
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