package com.gc.recommend.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gc.recommend.R;
import com.gc.recommend.adapter.DetailLeftViewAdapter;
import com.gc.recommend.adapter.DetailRightViewAdapter;
import com.gc.recommend.staticdata.LocalStaticData;

public class DetailLeftFragment extends Fragment {

    public RecyclerView mDetailLeftView;
    private DetailLeftViewAdapter mDetailLeftAdapter;
    public LocalStaticData mStaticData;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_left_fragment, container,false);
        mDetailLeftView = view.findViewById(R.id.detail_recyclerview);

        initDetailView();
        return view;
    }

    private void initDetailView() {
        mStaticData = LocalStaticData.getInstance();

        int a = LocalStaticData.getClothList().size();
        mDetailLeftAdapter = new DetailLeftViewAdapter(mStaticData.getClothList().get(0));
        mDetailLeftView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        mDetailLeftView.setAdapter(mDetailLeftAdapter);
    }
}
