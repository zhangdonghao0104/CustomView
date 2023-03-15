package com.zdh.custom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zdh.custom.databinding.ActivityMainBinding;
import com.zdh.custom.ui.CoordinatorToolbarActivity;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, SimpleActivity.class));
            }
        });
        binding.bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, BoardActivity.class));
            }
        });



    }
    public void coordinatorLayout(View view) {

        startActivity(new Intent(MainActivity.this, CoordinatorToolbarActivity.class));
    }
}