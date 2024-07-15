package com.example.erg2;

import static android.content.ContentValues.TAG;
import static android.content.Intent.getIntent;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class SubregionFragment extends Fragment implements View.OnClickListener {

    Button b1, b2, b3, b4;
    String region = "", poli = "", perioxi = "";

    public SubregionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            region = savedInstanceState.getString("region");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_subregion, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        if (savedInstanceState == null && bundle != null) {
            region = bundle.getString("key");
        }

        TextView tv = view.findViewById(R.id.subregion_textView);
        tv.setText(region);

        b1 = view.findViewById(R.id.button);
        b2 = view.findViewById(R.id.button2);
        b3 = view.findViewById(R.id.button3);
        b4 = view.findViewById(R.id.button4);

        enterRegionButtons(region);
    }


    @SuppressLint("SetTextI18n")
    public void enterRegionButtons(String region) {

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);

        switch (region) {
            case "Thessaly":
                b1.setText("KARDITSA");
                b2.setText("LARISA");
                b3.setText("MAGNISIA");
                b4.setText("TRIKALA");
                break;
            case "Central Greece":
                b1.setText("VIOTIA");
                b2.setText("EVIA");
                b3.setText("EVRITANIA");
                b4.setText("FTHIOTIDA");
                break;
            case "Central Macedonia":
                b1.setText("THESSALONIKI");
                b2.setText("SERRES");
                b3.setText("KILKIS");
                b4.setText("CHALKIDIKI");
                break;
            case "Thrace":
                b1.setText("EVROS");
                b2.setText("XANTHI");
                b3.setText("THASSOS");
                b4.setText("DRAMA");
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (region) {
            case "Central Greece":
                if (v.getId() == R.id.button) {
                    perioxi = "viotia";
                    poli = "levadia";
                } else if (v.getId() == R.id.button2) {
                    perioxi = "evia";
                    poli = "chalkida";
                } else if (v.getId() == R.id.button3) {
                    perioxi = "evritania";
                    poli = "karpenisi";
                } else if (v.getId() == R.id.button4) {
                    perioxi = "fthiotida";
                    poli = "stylida";
                }
                break;
            case "Thessaly":
                if (v.getId() == R.id.button) {
                    perioxi = "karditsa";
                    poli = "karditsa";
                } else if (v.getId() == R.id.button2) {
                    perioxi = "larisa";
                    poli = "larisa";
                } else if (v.getId() == R.id.button3) {
                    perioxi = "magnisia";
                    poli = "almiros";
                } else if (v.getId() == R.id.button4) {
                    perioxi = "trikala";
                    poli = "kalampaka";
                }
                break;
            case "Central Macedonia":
                if (v.getId() == R.id.button) {
                    perioxi = "thessaloniki";
                    poli = "thessaloniki";
                } else if (v.getId() == R.id.button2) {
                    perioxi = "serres";
                    poli = "sidirokastro";
                } else if (v.getId() == R.id.button3) {
                    perioxi = "kilkis";
                    poli = "goumenitsa";
                } else if (v.getId() == R.id.button4) {
                    perioxi = "chalkidiki";
                    poli = "kassandra";
                }
                break;
            case "Thrace":
                if (v.getId() == R.id.button) {
                    perioxi = "evros";
                    poli = "alexandroupoli";
                } else if (v.getId() == R.id.button2) {
                    perioxi = "xanthi";
                    poli = "komotini";
                } else if (v.getId() == R.id.button3) {
                    perioxi = "thassos";
                    poli = "limenaria";
                } else if (v.getId() == R.id.button4) {
                    perioxi = "drama";
                    poli = "drama";
                }
                break;
        }

        Bundle bundle = new Bundle();
        bundle.putString("perioxi", perioxi);
        bundle.putString("poli", poli);

        Fragment info_fragment = new InfoFragment();
        info_fragment.setArguments(bundle);

        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE)
            showLandscape(info_fragment);
        else if (orientation == Configuration.ORIENTATION_PORTRAIT)
            showPortrait(info_fragment);
    }


    public void showLandscape(Fragment fragment){
        getFragmentManager().beginTransaction()
                .replace(R.id.frag3, fragment)
                .addToBackStack(null)
                .commit();
    }

    public void showPortrait(Fragment fragment){
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("region", region);
    }
}
