package com.newproject.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnfragA, btnfragB, btnfragC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnfragA = findViewById(R.id.btnfragA);
        btnfragB = findViewById(R.id.btnfragB);
        btnfragC = findViewById(R.id.btnfragC);

//        To load default fragment whenever the app is opened
        loadFrag(new BFragment(), 0);

        btnfragA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFrag(new AFragment(), 1);
            }
        });

        btnfragB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFrag(new BFragment(), 1);
            }
        });

        btnfragC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFrag(new CFragment(), 1);
            }
        });


    }
    public void loadFrag(Fragment fragment, int flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if (flag==0)
            ft.add(R.id.container, fragment);
        else
            ft.replace(R.id.container, fragment);


        ft.commit();
    }
}