package com.example.myparcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class SimpleData implements Parcelable {

    int number;
    String message;

    public SimpleData(int number, String message) {
        this.number = number;
        this.message = message;
    }

    protected SimpleData(Parcel src) {
        number = src.readInt();
        message = src.readString();
    }

    public static final Creator CREATOR = new Creator() {

        public SimpleData createFromParcel(Parcel src){
            return new SimpleData(src);
        }

        public SimpleData[] newArray(int size){
            return new SimpleData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(number);
        dest.writeString(message);
    }
}
