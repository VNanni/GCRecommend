package com.gc.recommend.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gc.recommend.R;
import com.gc.recommend.adapter.DetailRightViewAdapter;
import com.gc.recommend.staticdata.LocalStaticData;

public class DetailSelectFragment extends Fragment {

    public RecyclerView mDetailRightView;
    private DetailRightViewAdapter mDetailRightAdapter;
    public LocalStaticData mStaticData;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_select_fragment, container,false);
        mDetailRightView = view.findViewById(R.id.cloth_select_recyclerview);

        initDetailView();
        return view;
    }

    private void initDetailView() {
        mStaticData = LocalStaticData.getInstance();

        mDetailRightAdapter = new DetailRightViewAdapter(mStaticData.getClothList());
        mDetailRightView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        mDetailRightView.setAdapter(mDetailRightAdapter);
    }
}
