package com.example.foodnutirentapp.data.entities.foodRecipesModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Qualifier {
    @SerializedName("uri")
    @Expose
    var uri: String? = null

    @SerializedName("label")
    @Expose
    var label: String? = null
}