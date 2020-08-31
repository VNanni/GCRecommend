package com.gc.recommend.activity;

import android.app.AppComponentFactory;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.gc.recommend.fragment.DetailFragment;

public class BrowseActivity extends AppCompatActivity {

    private Fragment mDetailFragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDetailFragment = new DetailFragment();
    }
}
