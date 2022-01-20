package com.example.farm;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    private CardView C;
    private Context mContext;
    private List<CardItem> listItems;
    private CardView cardView;
    CardAdapter(List<CardItem> listItems, Context context) {
        this.listItems = listItems;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
        C = v.findViewById(R.id.Cardview);
        return new ViewHolder(v, cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final CardItem listItem=listItems.get(position);
        holder.T.setText(listItem.getText1());
        C.setCardBackgroundColor(listItem.getColor());
        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,Problems.class);
                intent.putExtra("Grid", listItem.getText1());
                intent.putExtra("Color", listItem.getColor());
                intent.putExtra("Data", ""+listItem.getData());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView T;
        ViewHolder(@NonNull View itemView, CardView C) {
            super(itemView);
            T = itemView.findViewById(R.id.GridNum);
        }
    }
}

