package com.example.activity_intro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Dashboard extends AppCompatActivity {

    CardView roadCard;
    CardView elecCard;
    CardView streetCard;
    CardView wasteCard;
    CardView waterCard;
    CardView bridgeCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        roadCard = findViewById(R.id.roadCard);
        roadCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, road.class);
                startActivity(intent);

            }
        });
        elecCard = findViewById(R.id.elecCard);
        elecCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, electricity.class);
                startActivity(intent);

            }
        });
        streetCard = findViewById(R.id.streetCard);
        streetCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, streetlight.class);
                startActivity(intent);

            }
        });
        wasteCard = findViewById(R.id.wasteCard);
        wasteCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, waste.class);
                startActivity(intent);
            }
        });
        waterCard = findViewById(R.id.waterCard);
        waterCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, water.class);
                startActivity(intent);
            }
        });
        bridgeCard =  findViewById(R.id.bridgeCard);
        bridgeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, bridges.class);
                startActivity(intent);

            }
        });

    }
}