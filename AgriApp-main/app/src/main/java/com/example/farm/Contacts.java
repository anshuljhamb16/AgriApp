package com.example.farm;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class Contacts extends AppCompatActivity    {
    TextView t1,t2,t3,t4;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        t1 = findViewById(R.id.Link1);
        t2 = findViewById(R.id.Link2);
        t3 = findViewById(R.id.Link3);
        t4= findViewById(R.id.Link4);
        t1.setText(Html.fromHtml("<a href=\"https://www.bighaat.com/\">https://www.bighaat.com/</a>", Html.FROM_HTML_MODE_COMPACT));
        t2.setText(Html.fromHtml("<a href=\"https://agribegri.com/\">https://agribegri.com/</a>", Html.FROM_HTML_MODE_COMPACT));
        t3.setText(Html.fromHtml("<a href=\"https://agrowala.com/\">https://agrowala.com/</a>", Html.FROM_HTML_MODE_COMPACT));
        t4.setText(Html.fromHtml("<a href=\"https://www.agritell.com/\">https://www.agritell.com/</a>", Html.FROM_HTML_MODE_COMPACT));

    }
}
