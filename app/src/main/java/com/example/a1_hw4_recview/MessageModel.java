package com.example.a1_hw4_recview;


import android.os.Parcel;
import android.os.Parcelable;

public class MessageModel implements Parcelable {
    private String name;
    private String message;

    public MessageModel(String name, String message) {
        this.name = name;
        this.message = message;
    }

    protected MessageModel(Parcel in) {
        name = in.readString();
        message = in.readString();
    }

    public static final Creator<MessageModel> CREATOR = new Creator<MessageModel>() {
        @Override
        public MessageModel createFromParcel(Parcel in) {
            return new MessageModel(in);
        }

        @Override
        public MessageModel[] newArray(int size) {
            return new MessageModel[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(message);
    }
}
