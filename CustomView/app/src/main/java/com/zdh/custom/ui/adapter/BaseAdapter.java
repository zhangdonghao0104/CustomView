package com.zdh.custom.ui.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.zdh.custom.R;
import com.zdh.custom.ui.data.CoordinatorData;

import java.util.ArrayList;
import java.util.List;

public class BaseAdapter extends BaseQuickAdapter<CoordinatorData, BaseViewHolder> {
    private Context context;
    private List<CoordinatorData> arrayList = new ArrayList<>();

    public BaseAdapter(int layoutResId, @Nullable List<CoordinatorData> data) {
        super(layoutResId, data);
        arrayList = data;
    }


    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, CoordinatorData coordinatorData) {
        baseViewHolder.setText(R.id.item_tv, coordinatorData.getContent());
    }

}
