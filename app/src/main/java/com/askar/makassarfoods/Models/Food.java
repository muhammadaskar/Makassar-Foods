package com.askar.makassarfoods.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Food implements Parcelable {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("imgView")
    @Expose
    private String photo;

    @SerializedName("nama")
    @Expose
    private String nama;

    @SerializedName("jenis")
    @Expose
    private String jenis;

    @SerializedName("deskripsi")
    @Expose
    private String deskripsi;

    public Food() {
    }

    public Food(String nama, String jenis) {
        this.nama = nama;
        this.jenis = jenis;
    }

    public Food(String photo, String nama, String jenis) {
        this.photo = photo;
        this.nama = nama;
        this.jenis = jenis;
    }

    public Food(String photo, String nama, String jenis, String deskripsi) {
        this.photo = photo;
        this.nama = nama;
        this.jenis = jenis;
        this.deskripsi = deskripsi;
    }

    public Food(int id, String photo, String nama, String jenis, String deskripsi) {
        this.id = id;
        this.photo = photo;
        this.nama = nama;
        this.jenis = jenis;
        this.deskripsi = deskripsi;
    }

    protected Food(Parcel in) {
        id = in.readInt();
        photo = in.readString();
        nama = in.readString();
        jenis = in.readString();
        deskripsi = in.readString();
    }

    public static final Creator<Food> CREATOR = new Creator<Food>() {
        @Override
        public Food createFromParcel(Parcel in) {
            return new Food(in);
        }

        @Override
        public Food[] newArray(int size) {
            return new Food[size];
        }
    };

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(photo);
        parcel.writeString(nama);
        parcel.writeString(jenis);
        parcel.writeString(deskripsi);
    }
}
