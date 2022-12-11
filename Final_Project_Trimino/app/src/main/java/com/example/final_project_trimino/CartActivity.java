package com.example.final_project_trimino;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CartActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerViewAdapterCart recyclerViewAdapterCart;
    Button checkout, apply;
    TextView totalCheckout;
    EditText coupon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        checkout = findViewById(R.id.checkoutBtn);
        apply = findViewById(R.id.applyBtn);

        coupon = findViewById(R.id.couponET);

        totalCheckout = findViewById(R.id.cartamount);

        recyclerView = findViewById(R.id.rvCart);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        //View
        FirebaseRecyclerOptions<Pizza> options =
                new FirebaseRecyclerOptions.Builder<Pizza>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Pizza"), Pizza.class)
                        .build();

        recyclerViewAdapterCart = new RecyclerViewAdapterCart(options);
        recyclerView.setAdapter(recyclerViewAdapterCart);

        FirebaseDatabase.getInstance().getReference().child("Pizza")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        final int[] sum = {0};
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            Pizza pizza = snapshot.getValue(Pizza.class);
                            System.out.println(pizza.getTotal());
                            sum[0] += pizza.getTotal();

                            totalCheckout.setText(sum[0] + "$");

                            apply.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    if(coupon.getText().toString().equals("001")){
                                        sum[0] = sum[0] -2;
                                        totalCheckout.setText(sum[0] + "$");
                                    }
                                    if(coupon.getText().toString().equals("002")){
                                        sum[0] = sum[0] -2;
                                        totalCheckout.setText(sum[0] + "$");
                                    }
                                    if(coupon.getText().toString().equals("003")){
                                        sum[0] = sum[0] -2;
                                        totalCheckout.setText(sum[0] + "$");
                                    }
                                    if(coupon.getText().toString().equals("004")){
                                        sum[0] = sum[0] -2;
                                        totalCheckout.setText(sum[0] + "$");
                                    }
                                    if(coupon.getText().toString().equals("005")){
                                        sum[0] = sum[0] -2;
                                        totalCheckout.setText(sum[0] + "$");
                                    }
                                    if(coupon.getText().toString().equals("006")){
                                        sum[0] = sum[0] -2;
                                        totalCheckout.setText(sum[0] + "$");
                                    }
                                }
                            });
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CartActivity.this, CheckoutActivity.class);
                startActivity(i);
            }
        });

//        apply.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(coupon.getText().toString().equals("123")){
//                    totalCheckout.getText();
//                }
//            }
//        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        recyclerViewAdapterCart.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        recyclerViewAdapterCart.stopListening();
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
                Intent k = new Intent(CartActivity.this, MainActivity.class);
                startActivity(k);
                return true;
            case R.id.menu:
                Toast.makeText(this, "Menu is selected", Toast.LENGTH_SHORT).show();
                Intent l = new Intent(CartActivity.this, MenuActivity.class);
                startActivity(l);
                return true;
            case R.id.coupons:
                Toast.makeText(this, "Coupon is selected", Toast.LENGTH_SHORT).show();
                Intent e = new Intent(CartActivity.this, CouponActivity.class);
                startActivity(e);
                return true;
            case R.id.location:
                Toast.makeText(this, "Location is selected", Toast.LENGTH_SHORT).show();
                Intent a = new Intent(CartActivity.this, LocationActivity.class);
                startActivity(a);
                return true;
            case R.id.contact:
                Toast.makeText(this, "Contact is selected", Toast.LENGTH_SHORT).show();
                Intent b = new Intent(CartActivity.this, ContactActivity.class);
                startActivity(b);
                return true;
            case R.id.music:
                Toast.makeText(this, "Music is selected", Toast.LENGTH_SHORT).show();
                Intent f = new Intent(CartActivity.this, MusicActivity.class);
                startActivity(f);
                return true;
            case R.id.logout:
                Toast.makeText(this, "Logout is selected", Toast.LENGTH_SHORT).show();
                Intent d = new Intent(CartActivity.this, LoginActivity.class);
                startActivity(d);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}