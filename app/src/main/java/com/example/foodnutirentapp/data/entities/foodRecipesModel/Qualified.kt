package com.example.foodnutirentapp.data.entities.foodRecipesModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Qualified {
    @SerializedName("qualifiers")
    @Expose
    var qualifiers: List<Qualifier>? = null

    @SerializedName("weight")
    @Expose
    var weight: Double? = null
}