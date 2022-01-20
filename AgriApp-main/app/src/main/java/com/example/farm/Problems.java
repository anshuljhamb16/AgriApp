package com.example.farm;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Objects;

public class Problems extends AppCompatActivity {

    TextView t1, t2;
    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problems);
        t1 = findViewById(R.id.GridNumber);
        t2 = findViewById(R.id.Problems);
        String GridNum = getIntent().getStringExtra("Grid");
        t1.setText(GridNum);
        int a = getIntent().getIntExtra("Color",0);
        Log.e("A",""+a);
        getWindow().getDecorView().setBackgroundColor(getIntent().getIntExtra("Color",0));
        double d = Double.parseDouble(Objects.requireNonNull(getIntent().getStringExtra("Data")));
        if(a== -3407872)
        {
            t2.setText("Arduino error: Arduino no. x might have turned off... for such kind of an error contact the company for more details");
        }
        else if(d > 0)
        {
             t2.setText("Excess moisture content warning: the moisture content in grid "+GridNum+" is too high. The flow of water will remain closed for 1 hour. You can turn on the water supply manually too");
        }
        else if(d < 0)
        {
            t2.setText("Less moisture content warning: the moisture content in grid "+GridNum+" is lesser than the nominal amount. The flow of water will continue for "+(-1*d)+" minutes. You can turn the water supply off manually too.");
        }
        else
        {
            t2.setText("The grid is in perfect condition");
        }

    }

}