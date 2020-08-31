package com.gc.recommend.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gc.recommend.R;
import com.gc.recommend.beans.LocalClothBean;

import java.util.ArrayList;
import java.util.List;

public class DetailLeftViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int sFixCount = 2;

    private static int DETAIL_HEADER=0;
    private static int DETAIL_TITLE=1;
    private static int DETAIL_CONTENT=2;

    private LocalClothBean mGoodsinfo;

    public DetailLeftViewAdapter(LocalClothBean goods) {
        this.mGoodsinfo = goods;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        switch (viewType){
            case 0:{
                return new DetailHeaderViewHolder(mInflater.inflate(R.layout.detail_header,parent,false));
            }
            case 1:{
                return new DetailTitleViewHolder(mInflater.inflate(R.layout.detail_goods_title,parent,false));
            }
            default:{
                return new DetailCommentViewHolder(mInflater.inflate(R.layout.detail_comment,parent,false));
            }
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof DetailHeaderViewHolder){
            ((DetailHeaderViewHolder) holder).mHeaderPic.setImageResource(mGoodsinfo.getmLocalPic());
        }else if(holder instanceof DetailTitleViewHolder){
            ((DetailTitleViewHolder) holder).mGoodsPrice.setText(mGoodsinfo.getmPrice());
            ((DetailTitleViewHolder) holder).mGoodsName.setText(mGoodsinfo.getmName());
        }else if(holder instanceof DetailCommentViewHolder){
            ((DetailCommentViewHolder) holder).mCommentText.setText(mGoodsinfo.getmComment().get(position-sFixCount+1));
        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (position){
            case 0:{
                return DETAIL_HEADER;
            }
            case 1:{
                return DETAIL_TITLE;
            }
            default:{
                return DETAIL_CONTENT;
            }
        }
    }

    @Override
    public int getItemCount() {
        return sFixCount+mGoodsinfo.getCommentCount();
    }

    public class DetailHeaderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView mHeaderPic;
        public DetailHeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            mHeaderPic = itemView.findViewById(R.id.detail_header);
        }
        @Override
        public void onClick(View v) {

        }
    }

    public class DetailTitleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView mGoodsPrice;
        public TextView mGoodsName;
        public DetailTitleViewHolder(@NonNull View itemView) {
            super(itemView);
            mGoodsPrice = itemView.findViewById(R.id.goods_price_text);
            mGoodsName = itemView.findViewById(R.id.goods_name_text);
        }
        @Override
        public void onClick(View v) {

        }
    }

    public class DetailCommentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView mCommentText;
        public DetailCommentViewHolder(@NonNull View itemView) {
            super(itemView);
            mCommentText = itemView.findViewById(R.id.comment_text);
        }
        @Override
        public void onClick(View v) {

        }
    }
}
