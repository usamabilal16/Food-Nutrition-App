package com.example.foodnutirentapp.data.entities.foodRecipesModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Food {
    @SerializedName("foodId")
    @Expose
    var foodId: String? = ""

    @SerializedName("label")
    @Expose
    var label: String? = "null"

    @SerializedName("nutrients")
    @Expose
    var nutrients: Nutrients? = null

    @SerializedName("category")
    @Expose
    var category: String? = "null"

    @SerializedName("categoryLabel")
    @Expose
    var categoryLabel: String? = "null"

    @SerializedName("image")
    @Expose
    var image: String? = "null"

    @SerializedName("servingsPerContainer")
    @Expose
    var servingsPerContainer: Double? = 0.0
}