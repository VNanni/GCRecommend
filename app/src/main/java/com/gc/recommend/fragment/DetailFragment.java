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

public class DetailFragment extends Fragment {

    public RecyclerView mDetailLeftView;
    private DetailLeftViewAdapter mDetailLeftAdapter;
    public RecyclerView mDetailRightView;
    private DetailRightViewAdapter mDetailRightAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_fragment, container,false);
        mDetailLeftView = view.findViewById(R.id.detail_recyclerview);
        mDetailRightView = view.findViewById(R.id.cloth_select_recyclerview);

        initDetailView();
        return view;
    }

    private void initDetailView() {
        mDetailLeftAdapter = new DetailLeftViewAdapter(LocalStaticData.getClothList().get(0));
        mDetailLeftView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        mDetailLeftView.setAdapter(mDetailLeftAdapter);

        mDetailRightAdapter = new DetailRightViewAdapter(LocalStaticData.getClothList());
        mDetailRightView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        mDetailRightView.setAdapter(mDetailRightAdapter);
    }
}
