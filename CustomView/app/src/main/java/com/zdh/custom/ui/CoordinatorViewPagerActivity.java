package com.zdh.custom.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.zdh.custom.R;
import com.zdh.custom.databinding.ActivityCoordinatorlayoutBinding;
import com.zdh.custom.ui.adapter.CoordinatorLayoutAdapter;
import com.zdh.custom.ui.data.CoordinatorData;

import java.util.ArrayList;

public class CoordinatorViewPagerActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ActivityCoordinatorlayoutBinding binding;
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_coordinatorlayout);
        ArrayList<CoordinatorData> coordinatorDataList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            CoordinatorData coordinatorData = new CoordinatorData("我是item" + i);
            coordinatorDataList.add(coordinatorData);
        }
        CoordinatorLayoutAdapter layoutAdapter = new CoordinatorLayoutAdapter(R.layout.coordinator_item, coordinatorDataList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(CoordinatorViewPagerActivity.this);
        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setAdapter(layoutAdapter);
    }
}
