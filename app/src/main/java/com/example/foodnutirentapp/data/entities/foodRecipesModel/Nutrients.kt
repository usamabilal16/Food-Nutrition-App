package com.example.foodnutirentapp.data.entities.foodRecipesModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Nutrients {
    @SerializedName("ENERC_KCAL")
    @Expose
    var enercKcal: Double? = 0.0

    @SerializedName("PROCNT")
    @Expose
    var procnt: Double? = 0.0

    @SerializedName("FAT")
    @Expose
    var fat: Double? = 0.0

    @SerializedName("CHOCDF")
    @Expose
    var chocdf: Double? = 0.0

    @SerializedName("FIBTG")
    @Expose
    var fibtg: Double? = 0.0
}