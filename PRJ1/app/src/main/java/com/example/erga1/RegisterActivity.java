package com.example.erga1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText first_name = (EditText) findViewById(R.id.enterFirstName);
        EditText last_name = (EditText) findViewById(R.id.enterLastName);
        Button done = (Button) findViewById(R.id.done);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (first_name.getText().toString().matches("") && last_name.getText().toString().matches("")) {
                    first_name.setError("Please enter your first name");
                    last_name.setError("Please enter your last name");
                } else if (first_name.getText().toString().matches("")){
                    first_name.setError("Please enter your first name");
                } else if (last_name.getText().toString().matches("")) {
                        last_name.setError("Please enter your last name");
                } else{
                    String firstName =first_name.getText().toString();
                    String lastName = last_name.getText().toString();
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    intent.putExtra("firstName", firstName);
                    intent.putExtra("lastName", lastName);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}