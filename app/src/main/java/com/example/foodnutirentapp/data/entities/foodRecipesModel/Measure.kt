package com.example.foodnutirentapp.data.entities.foodRecipesModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Measure {
    @SerializedName("uri")
    @Expose
    var uri: String? = null

    @SerializedName("label")
    @Expose
    var label: String? = null

    @SerializedName("weight")
    @Expose
    var weight: Double? = null

    @SerializedName("qualified")
    @Expose
    var qualified: List<Qualified>? = null
}