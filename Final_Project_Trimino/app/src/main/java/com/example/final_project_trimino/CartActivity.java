package com.example.final_project_trimino;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class CartActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerViewAdapterCart recyclerViewAdapterCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerView = findViewById(R.id.rvCart);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Pizza> options =
                new FirebaseRecyclerOptions.Builder<Pizza>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Pizza"), Pizza.class)
                        .build();

        recyclerViewAdapterCart = new RecyclerViewAdapterCart(options);
        recyclerView.setAdapter(recyclerViewAdapterCart);
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

}