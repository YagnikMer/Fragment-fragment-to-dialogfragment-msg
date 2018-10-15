package com.worldmer.fragdialogdemo;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnFrag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
        addListener();
    }

    public void bindView() {
        btnFrag = findViewById(R.id.btnfrag);
    }

    public void addListener() {
        btnFrag.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnfrag:
                MainFragment mainFragment = new MainFragment();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(android.R.id.content, mainFragment,mainFragment.getClass().getName());
                transaction.addToBackStack(mainFragment.getClass().getName());
                transaction.commit();
                break;
        }
    }
}
