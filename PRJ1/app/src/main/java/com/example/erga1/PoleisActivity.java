package com.example.erga1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Locale;

public class PoleisActivity extends AppCompatActivity {

    double latitude, longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poleis);

        TextView message = (TextView) findViewById(R.id.message);
        FloatingActionButton fab1 = findViewById(R.id.floatingActionButton);
        FloatingActionButton fab2 = findViewById(R.id.floatingActionButton2);

        String perioxi = getIntent().getStringExtra("perioxi");
        String poli = getIntent().getStringExtra("poli");
        message.setText("A city in the region of " + perioxi.toUpperCase() + " is " + poli.toUpperCase());

        fab1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                getCoordinates(poli);
                Uri geolocation = Uri.parse("geo:<" + latitude  + ">,<" + longitude + ">?q=<" + latitude  + ">,<" + longitude + ">(" + perioxi.toUpperCase() + ", " + poli.toUpperCase() + ")");
                Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, geolocation);
                startActivity(mapIntent);
                finish();
            }
        });

        fab2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String url = getUrl(poli);
                Intent infoIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(infoIntent);
                finish();
            }
        });
    }

    public void getCoordinates(String poli) {
        switch (poli) {
            case "levadia":
                latitude = 38.43878750636495;
                longitude = 22.875107199533176;
                break;
            case "chalkida":
                latitude = 38.46860787918525;
                longitude = 23.622213536817377;
                break;
            case "karpenisi":
                latitude = 38.915926931180074;
                longitude = 21.793554605433798;
                break;
            case "stylida":
                latitude = 38.912348468805384;
                longitude = 22.616272289748466;
                break;
            case "karditsa":
                latitude = 39.364508410780424;
                longitude = 21.921387526357307;
                break;
            case "larisa":
                latitude = 39.63919784345092;
                longitude = 22.41710729124377;
                break;
            case "almiros":
                latitude = 39.18228113351006;
                longitude = 22.75895650102505;
                break;
            case "kalampaka":
                latitude = 39.70654996273837;
                longitude = 21.628288767720974;
                break;
            case "thessaloniki":
                latitude = 40.639554424613344;
                longitude = 22.941906643917697;
                break;
            case "sidirokastro":
                latitude = 41.234776878694575;
                longitude = 23.39436582884279;
                break;
            case "goumenissa":
                latitude = 40.946853740387986;
                longitude = 22.45111961246561;
                break;
            case "kassandra":
                latitude = 40.04782443461842;
                longitude = 23.41341170855107;
                break;
            case "alexandroupoli":
                latitude = 40.84536779446086;
                longitude = 25.874022706030306;
                break;
            case "komotini":
                latitude = 41.12236235568472;
                longitude = 25.406843136223387;
                break;
            case "limenaria":
                latitude = 40.62828787585162;
                longitude = 24.576319431166173;
                break;
            case "drama":
                latitude = 41.15042608873971;
                longitude = 24.146963931734508;
                break;
        }
    }

    public String getUrl(String poli) {
        String url=null;
        switch (poli) {
            case "levadia":
                url = "https://el.wikipedia.org/wiki/%CE%9B%CE%B9%CE%B2%CE%B1%CE%B4%CE%B5%CE%B9%CE%AC";
                break;
            case "chalkida":
                url = "https://el.wikipedia.org/wiki/%CE%A7%CE%B1%CE%BB%CE%BA%CE%AF%CE%B4%CE%B1";
                break;
            case "karpenisi":
                url = "https://el.wikipedia.org/wiki/%CE%9A%CE%B1%CF%81%CF%80%CE%B5%CE%BD%CE%AE%CF%83%CE%B9";
                break;
            case "stylida":
                url = "https://el.wikipedia.org/wiki/%CE%A3%CF%84%CF%85%CE%BB%CE%AF%CE%B4%CE%B1";
                break;
            case "karditsa":
                url="https://el.wikipedia.org/wiki/%CE%9A%CE%B1%CF%81%CE%B4%CE%AF%CF%84%CF%83%CE%B1";
                break;
            case "larisa":
                url = "https://el.wikipedia.org/wiki/%CE%9B%CE%AC%CF%81%CE%B9%CF%83%CE%B1";
                break;
            case "almiros":
                url = "https://el.wikipedia.org/wiki/%CE%94%CE%AE%CE%BC%CE%BF%CF%82_%CE%91%CE%BB%CE%BC%CF%85%CF%81%CE%BF%CF%8D";
                break;
            case "kalampaka":
                url = "https://el.wikipedia.org/wiki/%CE%9A%CE%B1%CE%BB%CE%B1%CE%BC%CF%80%CE%AC%CE%BA%CE%B1";
                break;
            case "thessaloniki":
                url="https://el.wikipedia.org/wiki/%CE%98%CE%B5%CF%83%CF%83%CE%B1%CE%BB%CE%BF%CE%BD%CE%AF%CE%BA%CE%B7";
                break;
            case "sidirokastro":
                url="https://el.wikipedia.org/wiki/%CE%A3%CE%B9%CE%B4%CE%B7%CF%81%CF%8C%CE%BA%CE%B1%CF%83%CF%84%CF%81%CE%BF_%CE%A3%CE%B5%CF%81%CF%81%CF%8E%CE%BD";
                break;
            case "goumenissa":
                url="https://el.wikipedia.org/wiki/%CE%93%CE%BF%CF%85%CE%BC%CE%AD%CE%BD%CE%B9%CF%83%CF%83%CE%B1";
                break;
            case "kassandra":
                url="https://el.wikipedia.org/wiki/%CE%9A%CE%B1%CF%83%CF%83%CE%AC%CE%BD%CE%B4%CF%81%CE%B5%CE%B9%CE%B1";
                break;
            case "alexandroupoli":
                url="https://el.wikipedia.org/wiki/%CE%91%CE%BB%CE%B5%CE%BE%CE%B1%CE%BD%CE%B4%CF%81%CE%BF%CF%8D%CF%80%CE%BF%CE%BB%CE%B7";
                break;
            case "komotini":
                url="https://el.wikipedia.org/wiki/%CE%9A%CE%BF%CE%BC%CE%BF%CF%84%CE%B7%CE%BD%CE%AE";
                break;
            case "limenaria":
                url="https://el.wikipedia.org/wiki/%CE%9B%CE%B9%CE%BC%CE%B5%CE%BD%CE%AC%CF%81%CE%B9%CE%B1_%CE%98%CE%AC%CF%83%CE%BF%CF%85";
                break;
            case "drama":
                url="https://el.wikipedia.org/wiki/%CE%94%CF%81%CE%AC%CE%BC%CE%B1_%28%CF%80%CF%8C%CE%BB%CE%B7%29";
                break;
        }
        return url;
    }
}