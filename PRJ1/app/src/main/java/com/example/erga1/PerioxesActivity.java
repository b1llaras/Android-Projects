package com.example.erga1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PerioxesActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout thessaly, central_greece, central_macedonia, thrace;
    Button viotia, evia, evritania, fthiotida;
    Button karditsa, larisa, magnisia, trikala;
    Button thessaloniki, serres, kilkis, chalkidiki;
    Button evros, xanthi, thassos, drama;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perioxes);

        central_greece = findViewById(R.id.CentralGreece);
        thessaly = findViewById(R.id.Thessaly);
        central_macedonia = findViewById(R.id.CentralMacedonia);
        thrace = findViewById(R.id.Thrace);

        String perioxi = getIntent().getStringExtra("region");

        switch (perioxi) {
            case "Central Greece":
                Central_Greece();
                break;
            case "Thessaly":
                Thessaly();
                break;
            case "Central Macedonia":
                Central_Macedonia();
                break;
            case "Thrace":
                Thrace();
                break;
        }
    }

    public void Central_Greece(){
        central_greece.setVisibility(View.VISIBLE);
        thessaly.setVisibility(View.GONE);
        central_macedonia.setVisibility(View.GONE);
        thrace.setVisibility(View.GONE);

        viotia = (Button) findViewById(R.id.viotia);
        evia = (Button) findViewById(R.id.evia);
        evritania = (Button) findViewById(R.id.evritania);
        fthiotida = (Button) findViewById(R.id.fthiotida);

        viotia.setOnClickListener(this);
        evia.setOnClickListener(this);
        evritania.setOnClickListener(this);
        fthiotida.setOnClickListener(this);
    }

    public void Thessaly(){
        thessaly.setVisibility(View.VISIBLE);
        central_greece.setVisibility(View.GONE);
        central_macedonia.setVisibility(View.GONE);
        thrace.setVisibility(View.GONE);

        karditsa = (Button) findViewById(R.id.karditsa);
        larisa = (Button) findViewById(R.id.larisa);
        magnisia = (Button) findViewById(R.id.magnisia);
        trikala = (Button) findViewById(R.id.trikala);

        karditsa.setOnClickListener(this);
        larisa.setOnClickListener(this);
        magnisia.setOnClickListener(this);
        trikala.setOnClickListener(this);
    }

    public void Central_Macedonia(){
        central_macedonia.setVisibility(View.VISIBLE);
        thessaly.setVisibility(View.GONE);
        central_greece.setVisibility(View.GONE);
        thrace.setVisibility(View.GONE);

        thessaloniki = (Button) findViewById(R.id.thessaloniki);
        serres = (Button) findViewById(R.id.serres);
        kilkis = (Button) findViewById(R.id.kilkis);
        chalkidiki = (Button) findViewById(R.id.chalkidiki);

        thessaloniki.setOnClickListener(this);
        serres.setOnClickListener(this);
        kilkis.setOnClickListener(this);
        chalkidiki.setOnClickListener(this);
    }

    public void Thrace(){
        thrace.setVisibility(View.VISIBLE);
        central_greece.setVisibility(View.GONE);
        central_macedonia.setVisibility(View.GONE);
        thessaly.setVisibility(View.GONE);

        evros = (Button) findViewById(R.id.evros);
        xanthi = (Button) findViewById(R.id.xanthi);
        thassos = (Button) findViewById(R.id.thassos);
        drama = (Button) findViewById(R.id.drama);

        evros.setOnClickListener(this);
        xanthi.setOnClickListener(this);
        thassos.setOnClickListener(this);
        drama.setOnClickListener(this);
    }

    public void onClick(View v) {
        String perioxi = "";
        String poli = "";

        int id = v.getId();
        if (id == R.id.viotia){
            perioxi = "viotia";
            poli = "levadia";
        }
        else if (id == R.id.evia){
            perioxi = "evia";
            poli = "chalkida";
        }
        else if (id == R.id.evritania){
            perioxi = "evritania";
            poli = "karpenisi";
        }
        else if (id == R.id.fthiotida){
            perioxi = "fthiotida";
            poli = "stylida";
        }
        else if (id == R.id.karditsa){
            perioxi = "karditsa";
            poli = "karditsa";
        }
        else if (id == R.id.larisa){
            perioxi = "larisa";
            poli = "larisa";
        }
        else if (id == R.id.magnisia){
            perioxi = "magnisia";
            poli = "almiros";
        }
        else if (id == R.id.trikala){
            perioxi = "trikala";
            poli = "kalampaka";
        }
        else if (id == R.id.thessaloniki){
            perioxi = "thessaloniki";
            poli = "thessaloniki";
        }
        else if (id == R.id.serres){
            perioxi = "serres";
            poli = "sidirokastro";
        }
        else if (id == R.id.kilkis){
            perioxi = "kilkis";
            poli = "goumenissa";
        }
        else if (id == R.id.chalkidiki){
            perioxi = "chalkidiki";
            poli = "kassandra";
        }
        else if (id == R.id.evros){
            perioxi = "evros";
            poli = "alexandroupoli";
        }
        else if (id == R.id.xanthi){
            perioxi = "xanthi";
            poli = "komotini";
        }
        else if (id == R.id.thassos){
            perioxi = "thassos";
            poli = "limenaria";
        }
        else if (id == R.id.drama){
            perioxi = "drama";
            poli = "drama";
        }

        Intent i = new Intent(PerioxesActivity.this, PoleisActivity.class);
        i.putExtra("perioxi", perioxi);
        i.putExtra("poli", poli);
        startActivity(i);
        finish();
    }
}