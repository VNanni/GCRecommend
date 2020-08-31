package com.gc.recommend.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.gc.recommend.R;
import com.gc.recommend.activity.BrowseActivity;
import com.gc.recommend.adapter.HomeViewAdapter;
import com.gc.recommend.beans.LocalClothBean;
import com.gc.recommend.utils.LocalClothProvider;

import java.util.List;

public class HomeFragment  extends Fragment {

    private RecyclerView mHomeView;
    private HomeViewAdapter mHomeViewAdapter;
    private List<LocalClothBean> mClothList;
    private LocalClothProvider mLocalClothProvider;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container,false);
        mHomeView = view.findViewById(R.id.home_view);
        initView();
        return view;
    }

    private void initView() {
        mHomeView.setHasFixedSize(true);
        mHomeView.setLayoutManager(
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        );
        initData();
        mHomeViewAdapter = new HomeViewAdapter(mClothList);
        mHomeView.setAdapter(mHomeViewAdapter);
        mHomeViewAdapter.setmItemClickListerner(new HomeViewAdapter.ItemClickListerner() {
            @Override
            public void OnItemClick(View v) {
                Intent toDetailPage = new Intent(getContext(), BrowseActivity.class);
                startActivity(toDetailPage);
            }
        });
    }

    private void initData() {
        mLocalClothProvider = new LocalClothProvider(getContext());
        mClothList = mLocalClothProvider.getAll();
    }
}