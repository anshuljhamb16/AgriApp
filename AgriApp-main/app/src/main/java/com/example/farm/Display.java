package com.example.farm;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

public class Display extends AppCompatActivity {
    private CardAdapter adapter;
    ArrayList<CardItem> card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        card= new ArrayList<>();
        final DatabaseReference nm= FirebaseDatabase.getInstance().getReference("Comment1").child("Double");
        nm.addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                card.clear();
                if (dataSnapshot.exists()) {
                    for (int i = 1; i <= 20; i++) {
                        String a = Objects.requireNonNull(dataSnapshot.child("Data" + i).getValue()).toString();
                        int color;
                        final String substring = a.substring(0, a.length() - 3);
                        if (a.charAt(a.length() - 1) == '1') {
                            if(Double.parseDouble(substring)*10000 != 0.0) {
                                color = getResources().getColor(R.color.holo_red_light);
                            }
                            else {
                                color = getResources().getColor(R.color.android_green);
                            }

                            CardItem l = new CardItem("Grid " + i, color, Double.parseDouble(substring)*10000);
                            card.add(l);
                        }
                        else
                        {
                            color = getResources().getColor(R.color.holo_red_dark);
                            CardItem l = new CardItem("Grid " + i, color, Double.parseDouble(substring)*10000);
                            card.add(l);
                        }
                    }
                    create();
                    adapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                throw databaseError.toException();

            }

        });
    }

    private void create() {

        RecyclerView recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new CardAdapter(card, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setLayoutManager(layoutManager);
    }
}
