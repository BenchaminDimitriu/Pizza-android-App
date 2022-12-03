package com.example.final_project_trimino;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.slider.Slider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class cheese extends AppCompatActivity {

    Slider sizeSlider;
    CheckBox olives, mushrooms, peppers, onions, bacons, pineapples, excheese;
    Button totalBtn, orderBtn;
    TextView cheese;
    EditText total;
    int cost;

    FirebaseDatabase database;
    DatabaseReference reference;
    Pizza pizza;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheese);

        reference = database.getInstance().getReference().child("Pizza");
        pizza = new Pizza();

        cheese = findViewById(R.id.cheeseTxt);

        olives = findViewById(R.id.olivesBox);
        mushrooms = findViewById(R.id.mushroomsBox);
        peppers = findViewById(R.id.peppersBox);
        onions = findViewById(R.id.onionsBox);
        bacons =  findViewById(R.id.baconBitsBox);
        pineapples = findViewById(R.id.pineapplesBox);
        excheese = findViewById(R.id.extraCheeseBox);

        sizeSlider = findViewById(R.id.slider);

        totalBtn = findViewById(R.id.totalBtn);
        total = findViewById(R.id.cheeseTotal);

        orderBtn = findViewById(R.id.orderBtn);

        String p1 = "Small Pizza";
        String p2 = "Medium Pizza";
        String p3 = "Large Pizza";
        String p4 = "XLarge Pizza";

        String t1 = "Olives";
        String t2 = "Mushrooms";
        String t3 = "Peppers";
        String t4 = "Onions";
        String t5 = "Bacon Bits";
        String t6 = "Pineapples";
        String t7 = "Extra Cheese";

        String tp = "Type";

        String c = "Total";

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    i = (int) snapshot.getChildrenCount();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

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

        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(olives.isChecked()){
                    cost += 2;
                    pizza.setPizzaTopping1(t1);
                    reference.child(String.valueOf(i+1)).setValue(pizza);
                } if(mushrooms.isChecked()){
                    cost += 4;
                    pizza.setPizzaTopping2(t2);
                    reference.child(String.valueOf(i+1)).setValue(pizza);
                } if(peppers.isChecked()){
                    cost += 3;
                    pizza.setPizzaTopping3(t3);
                    reference.child(String.valueOf(i+1)).setValue(pizza);
                } if(onions.isChecked()){
                    cost += 2;
                    pizza.setPizzaTopping4(t4);
                    reference.child(String.valueOf(i+1)).setValue(pizza);
                } if(bacons.isChecked()){
                    cost += 4;
                    pizza.setPizzaTopping5(t5);
                    reference.child(String.valueOf(i+1)).setValue(pizza);
                } if(pineapples.isChecked()){
                    cost += 3;
                    pizza.setPizzaTopping6(t6);
                    reference.child(String.valueOf(i+1)).setValue(pizza);
                } if(excheese.isChecked()){
                    cost += 4;
                    pizza.setPizzaTopping7(t7);
                    reference.child(String.valueOf(i+1)).setValue(pizza);
                } if(sizeSlider.getValue()==0){
                    cost += 6;
                    pizza.setPizzaASmall(p1);
                    reference.child(String.valueOf(i+1)).setValue(pizza);
                } if(sizeSlider.getValue()==1){
                    cost += 8;
                    pizza.setPizzaAMedium(p2);
                    reference.child(String.valueOf(i+1)).setValue(pizza);
                } if(sizeSlider.getValue()==2){
                    cost += 11;
                    pizza.setPizzaALarge(p3);
                    reference.child(String.valueOf(i+1)).setValue(pizza);
                } if(sizeSlider.getValue()==3){
                    cost += 14;
                    pizza.setPizzaAXLarge(p4);
                    reference.child(String.valueOf(i+1)).setValue(pizza);
                }
                total.setText("Total Price: $"+String.valueOf(cost));
                pizza.setTotal((total.getText().toString().trim()));
                reference.child(String.valueOf(i+1)).setValue(pizza);

                pizza.setPizzaBType((cheese.getText().toString().trim()));
                reference.child(String.valueOf(i+1)).setValue(pizza);

                Intent i = new Intent(cheese.this, CartActivity.class);
                startActivity(i);
            }
        });
    }
}