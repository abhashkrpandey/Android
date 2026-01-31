package com.mydomain.compose_practice.models


import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable


@SuppressLint("ParcelCreator")
data class Movie(
    val movieId: Int,
    val movieName: String,
    val rating: Float
) : Parcelable {
    override fun describeContents(): Int {
        return  0;
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        return
    }
}