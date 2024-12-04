package com.example.activity_intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class complain extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button b1;
    EditText e1, e2, e3;
    Spinner s1;
    String[] ss1= {"Muncipal corporation","Ministry of Rural development" ,"Local government management", "Ministry of urban development"};
    ArrayAdapter aa;
    String dept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complain);
        b1 = findViewById(R.id.button);
        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        e3 = findViewById(R.id.e3);
        s1 = findViewById(R.id.spinner);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(complain.this, Dashboard.class);
                startActivity(intent);
            }
        });


        s1.setOnItemSelectedListener(this);
        aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, ss1);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(aa);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a1 = e1.getText().toString();
                String b1 = e2.getText().toString();
                String c1 = e3.getText().toString();

                if(a1.equals("")||b1.equals("")||c1.equals("")){
                    Toast.makeText(complain.this, "Please fill details", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(complain.this, "complain send successfully" +dept, Toast.LENGTH_SHORT).show();
                    e1.setText("");
                    e2.setText("");
                    e3.setText("");

                }
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        dept = (String)aa.getItem(position);





    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}