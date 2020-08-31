package com.gc.recommend.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gc.recommend.R;
import com.gc.recommend.customerview.RoundView;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MyViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int HEADER_TYPE=0;
    private static final int CARD1_TYPE=1;
    private static final int CARD2_TYPE=2;
    private static final int CARDTITLE1_TYPE=3;
    private static final int CARD3_TYPE=4;

    private final int mFixCount = 4;
    private LayoutInflater mInflater;
    private List<Integer> mGuessGoodsList;
    private Context mContext;

    public MyViewAdapter(Context context) {
        mContext = context;
        mGuessGoodsList = new ArrayList<>();
        initGoodsList();
    }

    private void initGoodsList() {
        mGuessGoodsList.add(R.mipmap.c1);
        mGuessGoodsList.add(R.mipmap.c2);
        mGuessGoodsList.add(R.mipmap.c3);
        mGuessGoodsList.add(R.mipmap.c4);
        mGuessGoodsList.add(R.mipmap.c5);
        mGuessGoodsList.add(R.mipmap.c6);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mInflater = LayoutInflater.from(parent.getContext());
        switch (viewType){
            case 0: {
                return new HeaderViewHolder(mInflater.inflate(R.layout.my_header, parent, false));
            }
            case 1:{
                return new FirstCardViewHolder(mInflater.inflate(R.layout.my_function_card1,parent,false));
            }
            case 2:{
                return new SecondCardViewHolder(mInflater.inflate(R.layout.my_function_card2,parent,false));
            }
            case 3:{
                return new CardTitleViewHolder(mInflater.inflate(R.layout.my_card_title1,parent,false));
            }
            default:{
                return new ThirdCardViewHolder(mInflater.inflate(R.layout.my_function_card3,parent,false));
            }
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof HeaderViewHolder){
            Picasso.with(mContext)
                    .load(R.mipmap.userhead)
                    .transform(new RoundView())
                    .into(((HeaderViewHolder) holder).mHeadPic);
            ((HeaderViewHolder) holder).mNameText.setText(R.string.username);
        }else if(holder instanceof FirstCardViewHolder){
            ((FirstCardViewHolder) holder).mOrderIcon.setImageResource(R.mipmap.c_order);
            ((FirstCardViewHolder) holder).mStarIcon.setImageResource(R.mipmap.c_star);
            ((FirstCardViewHolder) holder).mShopCarIcon.setImageResource(R.mipmap.c_shopcar);
            ((FirstCardViewHolder) holder).mHistoryIcon.setImageResource(R.mipmap.c_history);
        }else if(holder instanceof SecondCardViewHolder){
            ((SecondCardViewHolder) holder).mHeightIcon.setImageResource(R.mipmap.c_order);
            ((SecondCardViewHolder) holder).mWeightIcon.setImageResource(R.mipmap.c_order);
            ((SecondCardViewHolder) holder).mBustIcon.setImageResource(R.mipmap.c_order);
        }else if(holder instanceof CardTitleViewHolder){
            ((CardTitleViewHolder) holder).mGuessYouLikeText.setText(R.string.guessyoulike);
        }else if(holder instanceof ThirdCardViewHolder){
            ((ThirdCardViewHolder) holder).mGuessLeftPic.setImageResource(R.mipmap.c1);
            ((ThirdCardViewHolder) holder).mGuessRightPic.setImageResource(R.mipmap.c2);
        }
    }

    @Override
    public int getItemCount() {
        int tempcount = (mGuessGoodsList.size()+1)/2;
        return mFixCount+3;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position){
            case 0:{
                return HEADER_TYPE;
            }
            case 1:{
                return CARD1_TYPE;
            }
            case 2:{
                return CARD2_TYPE;
            }
            case 3:{
                return CARDTITLE1_TYPE;
            }
            default:{
                return CARD3_TYPE;
            }
        }
    }

    //头部布局
    public class HeaderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView mHeadPic;
        public TextView mNameText;
        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            mHeadPic = itemView.findViewById(R.id.user_head);
            mNameText = itemView.findViewById(R.id.user_name);
        }

        @Override
        public void onClick(View v) {

        }
    }

    //第一个卡片布局
    public class FirstCardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView mOrderIcon;
        public TextView mOrderText;
        public ImageView mStarIcon;
        public ImageView mShopCarIcon;
        public TextView mShopCarText;
        public ImageView mHistoryIcon;
        public TextView mHistoryText;
        public FirstCardViewHolder(@NonNull View itemView) {
            super(itemView);
            mOrderIcon = itemView.findViewById(R.id.my_order);
            mStarIcon = itemView.findViewById(R.id.my_star);
            mShopCarIcon = itemView.findViewById(R.id.my_shopcar);
            mHistoryIcon = itemView.findViewById(R.id.my_history);
        }

        @Override
        public void onClick(View v) {

        }
    }

    //第二个卡片布局
    public class SecondCardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView mHeightIcon;
        public ImageView mWeightIcon;
        public ImageView mBustIcon;
        public SecondCardViewHolder(@NonNull View itemView) {
            super(itemView);
            mHeightIcon = itemView.findViewById(R.id.my_height_icon);
            mWeightIcon = itemView.findViewById(R.id.my_weight_icon);
            mBustIcon = itemView.findViewById(R.id.my_bust_icon);
        }

        @Override
        public void onClick(View v) {

        }
    }

    //第三个卡片标题
    public class CardTitleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView mGuessYouLikeText;
        public CardTitleViewHolder(@NonNull View itemView) {
            super(itemView);
            mGuessYouLikeText = itemView.findViewById(R.id.guess_you_like);
        }

        @Override
        public void onClick(View v) {

        }
    }

    //第三个卡片布局
    public class ThirdCardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView mGuessLeftPic;
        public ImageView mGuessRightPic;
        public ThirdCardViewHolder(@NonNull View itemView) {
            super(itemView);
            mGuessLeftPic = itemView.findViewById(R.id.guess_left);
            mGuessRightPic = itemView.findViewById(R.id.guess_right);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
