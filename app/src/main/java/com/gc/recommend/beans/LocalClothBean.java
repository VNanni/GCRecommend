package com.gc.recommend.beans;

import android.widget.BaseAdapter;

public class LocalClothBean extends BaseBean {
    private String mName;
    private int mPrice;
    private int mLocalPic;
    private String mComment;

    public LocalClothBean(int mID, String mName, int mPrice, int mLocalPic, String mComment) {
        super(mID);
        this.mName = mName;
        this.mPrice = mPrice;
        this.mLocalPic = mLocalPic;
        this.mComment = mComment;
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

    public String getmComment() {
        return mComment;
    }

    public void setmComment(String mComment) {
        this.mComment = mComment;
    }
}
