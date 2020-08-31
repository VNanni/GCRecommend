package com.gc.recommend.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gc.recommend.R;
import com.gc.recommend.adapter.MyViewAdapter;
import com.gc.recommend.customerview.RoundView;
import com.squareup.picasso.Picasso;

public class MyFragment extends Fragment {


    public RecyclerView mMyRecycleView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment, container,false);

        mMyRecycleView = view.findViewById(R.id.my_recycleview);

        initMyView();
        return view;
    }

    private void initMyView() {
        mMyRecycleView.setAdapter(new MyViewAdapter(this.getActivity()));
        mMyRecycleView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
    }

}