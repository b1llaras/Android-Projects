package com.example.erga1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    LinearLayout screen1, screen2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen1 = (LinearLayout) findViewById(R.id.viotia);
        screen2 = (LinearLayout) findViewById(R.id.main2);
        Button b = (Button) findViewById(R.id.register);
        showScreen1();

        String firstName = getIntent().getStringExtra("firstName");
        String lastName = getIntent().getStringExtra("lastName");

        if (firstName != null && lastName != null) {
            showScreen2();
            TextView welcome = (TextView) findViewById(R.id.welcome2);
            welcome.setText("Welcome " + firstName + " " + lastName + ",\nNow lets start exploring our Application.\nSelect a region of Greece:");

            RadioGroup radioGroup = (RadioGroup) findViewById(R.id.regions);
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    String region = "";
                    View rb = radioGroup.findViewById(checkedId);
                    int index = radioGroup.indexOfChild(rb);
                    switch (index) {
                        case 0:
                            region = "Central Greece";
                            break;
                        case 1:
                            region = "Thessaly";
                            break;
                        case 2:
                            region = "Central Macedonia";
                            break;
                        case 3:
                            region = "Thrace";
                            break;
                    }
                    Intent intent = new Intent(MainActivity.this, PerioxesActivity.class);
                    intent.putExtra("region", region);
                    startActivity(intent);
                    finish();
                }
            });
        }
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void showScreen1(){
        screen1.setVisibility(View.VISIBLE);
        screen2.setVisibility(View.GONE);
    }

    public void showScreen2(){
        screen1.setVisibility(View.GONE);
        screen2.setVisibility(View.VISIBLE);
    }
}