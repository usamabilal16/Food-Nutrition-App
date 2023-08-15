package com.example.foodnutirentapp.data.entities.foodRecipesModel

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Hint() :Parcelable {
    @SerializedName("food")
    @Expose
    var food: Food__1? = null

    @SerializedName("measures")
    @Expose
    var measures: List<Measure>? = null
    var isSelected = false

    constructor(parcel: Parcel) : this() {
        isSelected = parcel.readByte() != 0.toByte()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeByte(if (isSelected) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Hint> {
        override fun createFromParcel(parcel: Parcel): Hint {
            return Hint(parcel)
        }

        override fun newArray(size: Int): Array<Hint?> {
            return arrayOfNulls(size)
        }
    }
}