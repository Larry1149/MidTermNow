package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class GameProfileActivity extends AppCompatActivity {

    TextView tvName,tvRate,tvPrice,tvDes;

    String sName,sRate,sPrice,sDes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_profile);

        sName = getIntent().getStringExtra("name");
        sRate = getIntent().getStringExtra("rate");
        sPrice = getIntent().getStringExtra("price");
        sDes = getIntent().getStringExtra("des");

        tvName = findViewById(R.id.tv_Profile_Name);
        tvName.setText(sName);

        tvRate = findViewById(R.id.tv_Profile_rate);
        tvRate.setText(sRate);

        tvPrice = findViewById(R.id.tv_Profile_Price);
        tvPrice.setText(sPrice);

        tvDes = findViewById(R.id.tv_Profile_Description);
        tvDes.setText(sDes);

    }
}
