package com.example.activity_intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class REGISTERR extends AppCompatActivity {

    EditText registerName, registerEmail, registerUsername, registerPassword;
    TextView loginnRedirectText;
    Button signupButton;
    FirebaseDatabase database;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerr2);
        registerName = findViewById(R.id.register_name);
        registerEmail = findViewById(R.id.register_email);
        registerUsername = findViewById(R.id.register_username);
        registerPassword = findViewById(R.id.register_password);
        signupButton = findViewById(R.id.register_button);
        loginnRedirectText = findViewById(R.id.loginnRedirectText);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");

                String name = registerName.getText().toString();
                String email = registerEmail.getText().toString();
                String username = registerUsername.getText().toString();
                String password = registerPassword.getText().toString();

                HelperClass helperClass = new HelperClass(name, email, username, password);
                reference.child(name).setValue(helperClass);

                Toast.makeText(REGISTERR.this, "You have registered successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(REGISTERR.this, lOGINN.class);
                startActivity(intent);
            }
        });
     loginnRedirectText.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent = new Intent(REGISTERR.this, Dashboard.class);
         }
     });
    }
 }
