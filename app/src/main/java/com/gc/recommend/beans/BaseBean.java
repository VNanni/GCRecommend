package com.gc.recommend.beans;

import java.io.Serializable;

public class BaseBean implements Serializable {
    private int mID;

    public BaseBean(int mID) {
        this.mID = mID;
    }

    public int getmID() {
        return mID;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }
}
