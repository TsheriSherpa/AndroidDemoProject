package com.example.myapplication

import android.os.Parcel
import android.os.Parcelable

data class ActivityMainBinding(val title: String?, val description: String?, val price: Double) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readDouble()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeDouble(price)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ActivityMainBinding> {
        override fun createFromParcel(parcel: Parcel): ActivityMainBinding {
            return ActivityMainBinding(parcel)
        }

        override fun newArray(size: Int): Array<ActivityMainBinding?> {
            return arrayOfNulls(size)
        }
    }
}
