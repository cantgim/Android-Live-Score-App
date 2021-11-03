package com.example.demolivescore.model;

import android.os.Parcel;
import android.os.Parcelable;

public class News implements Parcelable{
    int imgId;
    String itemTitle;
    String itemDetail;

    public News() {
    }

    public News(int imgId, String itemTitle, String itemDetail) {
        this.imgId = imgId;
        this.itemTitle = itemTitle;
        this.itemDetail = itemDetail;
    }

    protected News(Parcel in) {
        imgId = in.readInt();
        itemTitle = in.readString();
        itemDetail = in.readString();
    }

    public static final Creator<News> CREATOR = new Creator<News>() {
        @Override
        public News createFromParcel(Parcel in) {
            return new News(in);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemDetail() {
        return itemDetail;
    }

    public void setItemDetail(String itemDetail) {
        this.itemDetail = itemDetail;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(imgId);
        parcel.writeString(itemTitle);
        parcel.writeString(itemDetail);
    }
}
