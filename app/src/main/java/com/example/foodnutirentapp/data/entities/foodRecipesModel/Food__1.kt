package com.example.foodnutirentapp.data.entities.foodRecipesModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Food__1 {
    @SerializedName("foodId")
    @Expose
    var foodId: String? = null

    @SerializedName("label")
    @Expose
    var label: String? = null

    @SerializedName("nutrients")
    @Expose
    var nutrients: Nutrients__1? = null

    @SerializedName("category")
    @Expose
    var category: String? = null

    @SerializedName("categoryLabel")
    @Expose
    var categoryLabel: String? = null

    @SerializedName("image")
    @Expose
    var image: String? = null

    @SerializedName("servingsPerContainer")
    @Expose
    var servingsPerContainer: Double? = null

    @SerializedName("foodContentsLabel")
    @Expose
    var foodContentsLabel: String? = null
}