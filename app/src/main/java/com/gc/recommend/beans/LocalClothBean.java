package com.gc.recommend.beans;

import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

public class LocalClothBean extends BaseBean {
    private String mName;
    private int mPrice;
    private int mLocalPic;
    private List<String> mComment;

    public LocalClothBean(int mID, String mName, int mPrice, int mLocalPic, String mComment) {
        super(mID);
        this.mName = mName;
        this.mPrice = mPrice;
        this.mLocalPic = mLocalPic;
        this.mComment = new ArrayList<>();
        this.mComment.add(mComment);
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmPrice() {
        return mPrice;
    }

    public void setmPrice(int mPrice) {
        this.mPrice = mPrice;
    }

    public int getmLocalPic() {
        return mLocalPic;
    }

    public void setmLocalPic(int mLocalPic) {
        this.mLocalPic = mLocalPic;
    }

    public List<String> getmComment() {
        return mComment;
    }

    public void setmComment(List<String> mComment) {
        this.mComment = mComment;
    }
    public int getCommentCount(){
        return mComment.size();
    }
}
