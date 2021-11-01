package com.example.demolivescore.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable{
    int imgId;
    String itemTitle;
    String itemDetail;

    public Item() {
    }

    public Item(int imgId, String itemTitle, String itemDetail) {
        this.imgId = imgId;
        this.itemTitle = itemTitle;
        this.itemDetail = itemDetail;
    }

    protected Item(Parcel in) {
        imgId = in.readInt();
        itemTitle = in.readString();
        itemDetail = in.readString();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
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
