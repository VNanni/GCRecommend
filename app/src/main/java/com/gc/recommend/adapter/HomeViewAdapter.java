package com.gc.recommend.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.gc.recommend.R;
import com.gc.recommend.beans.LocalClothBean;
import java.util.ArrayList;
import java.util.List;

public class HomeViewAdapter extends RecyclerView.Adapter<HomeViewAdapter.HomeViewHolder> {

    private LayoutInflater mInflater;
    private ItemClickListerner mItemClickListerner;
    private List<LocalClothBean> mClothList;

    public HomeViewAdapter(List<LocalClothBean> mClothList) {
        this.mClothList = mClothList;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mInflater = LayoutInflater.from(parent.getContext());
        View view = mInflater.inflate(R.layout.home_item, null);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        holder.mClothPic.setImageResource(mClothList.get(position).getmLocalPic());
        holder.mClothTitle.setText(mClothList.get(position).getmName());
    }

    @Override
    public int getItemCount() {
        return mClothList != null ? mClothList.size() : 0;
    }

    public interface ItemClickListerner{
        void OnItemClick(View v);
    }

    public void setmItemClickListerner(ItemClickListerner mItemClickListerner) {
        this.mItemClickListerner = mItemClickListerner;
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView mClothPic;
        public TextView mClothTitle;
        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            mClothPic = itemView.findViewById(R.id.cloth_pic);
            mClothTitle = itemView.findViewById(R.id.cloth_title);
            mClothPic.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(mItemClickListerner!=null){
                mItemClickListerner.OnItemClick(v);
            }
        }
    }
}
