package com.example.final_project_trimino;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapterCart extends FirebaseRecyclerAdapter<Pizza,RecyclerViewAdapterCart.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public RecyclerViewAdapterCart(@NonNull FirebaseRecyclerOptions<Pizza> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, @SuppressLint("RecyclerView") int position, @NonNull Pizza model) {
        holder.top1.setText(model.getPizzaTopping1());
        holder.top2.setText(model.getPizzaTopping2());
        holder.top3.setText(model.getPizzaTopping3());
        holder.top4.setText(model.getPizzaTopping4());
        holder.top5.setText(model.getPizzaTopping5());
        holder.top6.setText(model.getPizzaTopping6());
        holder.top7.setText(model.getPizzaTopping7());

        holder.sizeS.setText(model.getPizzaASmall());
        holder.sizeM.setText(model.getPizzaAMedium());
        holder.sizeL.setText(model.getPizzaALarge());
        holder.sizeXL.setText(model.getPizzaAXLarge());

        holder.type.setText(model.getPizzaBType());
        holder.total.setText(model.getTotal());

        holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.type.getContext());
                builder.setTitle("Are you sure?");
                builder.setMessage("Pizza will be deleted");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("Pizza")
                                .child(Objects.requireNonNull(getRef(position).getKey())).removeValue();
                        Toast.makeText(holder.type.getContext(), "Deleted", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(holder.type.getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_child_cart,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        CircleImageView img;
        TextView sizeS, sizeM, sizeL, sizeXL, type, top1, top2, top3, top4, top5, top6 ,top7, total;
        Button deleteBtn;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            img = (CircleImageView) itemView.findViewById(R.id.img);
            sizeS = (TextView) itemView.findViewById(R.id.pizzaSizeTxt1);
            sizeM = (TextView) itemView.findViewById(R.id.pizzaSizeTxt2);
            sizeL = (TextView) itemView.findViewById(R.id.pizzaSizeTxt3);
            sizeXL = (TextView) itemView.findViewById(R.id.pizzaSizeTxt4);
            type = (TextView) itemView.findViewById(R.id.pizzaTypeTxt);
            top1 = (TextView) itemView.findViewById(R.id.pizzaTopTxt1);
            top2 = (TextView) itemView.findViewById(R.id.pizzaTopTxt2);
            top3 = (TextView) itemView.findViewById(R.id.pizzaTopTxt3);
            top4 = (TextView) itemView.findViewById(R.id.pizzaTopTxt4);
            top5 = (TextView) itemView.findViewById(R.id.pizzaTopTxt5);
            top6 = (TextView) itemView.findViewById(R.id.pizzaTopTxt6);
            top7 = (TextView) itemView.findViewById(R.id.pizzaTopTxt7);
            total = (TextView) itemView.findViewById(R.id.pizzaTotalTxt);

            deleteBtn = (Button) itemView.findViewById(R.id.deleteBtn);

        }
    }
}
