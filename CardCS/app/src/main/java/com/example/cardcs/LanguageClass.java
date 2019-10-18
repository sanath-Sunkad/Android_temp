package com.example.cardcs;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class LanguageClass implements Parcelable {

    private String name;
    private int image;

    LanguageClass(String title,int im)
    {
        this.name=title;
        this.image=im;

    }

    protected LanguageClass(Parcel in) {
        name = in.readString();
        image = in.readInt();
    }

    public static final Creator<LanguageClass> CREATOR = new Creator<LanguageClass>() {
        @Override
        public LanguageClass createFromParcel(Parcel in) {
            return new LanguageClass(in);
        }

        @Override
        public LanguageClass[] newArray(int size) {
            return new LanguageClass[size];
        }
    };

    public String getName()
    {
        return name;

    }

    int getImage()
    {
        return image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(image);
    }
}
