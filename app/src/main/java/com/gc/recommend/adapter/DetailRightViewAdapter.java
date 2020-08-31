package com.gc.recommend.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gc.recommend.R;
import com.gc.recommend.beans.LocalClothBean;

import java.util.List;

public class DetailRightViewAdapter extends RecyclerView.Adapter<DetailRightViewAdapter.DetailListViewHolder> {

    private List<LocalClothBean> mGoodsList;

    public DetailRightViewAdapter(List<LocalClothBean> mGoodsList) {
        this.mGoodsList = mGoodsList;
    }

    @NonNull
    @Override
    public DetailListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());

        return new DetailListViewHolder(mInflater.inflate(R.layout.detail_goods_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DetailListViewHolder holder, int position) {
        holder.mDetailList.setImageResource(mGoodsList.get(position).getmLocalPic());
    }

    @Override
    public int getItemCount() {
        return mGoodsList.size();
    }

    public class DetailListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView mDetailList;
        public DetailListViewHolder(@NonNull View itemView) {
            super(itemView);
            mDetailList = itemView.findViewById(R.id.detail_list);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
