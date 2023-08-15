package com.example.foodnutirentapp.data.entities.foodRecipesModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Next {
    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("href")
    @Expose
    var href: String? = null
}