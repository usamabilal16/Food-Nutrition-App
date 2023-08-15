package com.example.foodnutirentapp.data.entities.foodRecipesModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Parsed {
    @SerializedName("food")
    @Expose
    var food: Food? = null
}