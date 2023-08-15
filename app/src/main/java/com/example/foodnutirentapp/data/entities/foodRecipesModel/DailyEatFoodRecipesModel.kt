package com.example.foodnutirentapp.data.entities.foodRecipesModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DailyEatFoodRecipesModel {
    @SerializedName("text")
    @Expose
    var text: String? = null

    @SerializedName("parsed")
    @Expose
    var parsed: List<Parsed> = ArrayList()

    @SerializedName("hints")
    @Expose
    var hints: List<Hint>? = null

    @SerializedName("_links")
    @Expose
    var links: Links? = null
}