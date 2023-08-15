package com.example.foodnutirentapp.data.entities.foodRecipesModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Nutrients__1 {
    @SerializedName("ENERC_KCAL")
    @Expose
    var enercKcal: Double? = null

    @SerializedName("PROCNT")
    @Expose
    var procnt: Double? = null

    @SerializedName("FAT")
    @Expose
    var fat: Double? = null

    @SerializedName("CHOCDF")
    @Expose
    var chocdf: Double? = null

    @SerializedName("FIBTG")
    var itemTitle: String? = null
    var totalCalories: String? = null
    var dbTitle: String? = null

    @Expose
    var fibtg: Double? = null

    constructor()
    constructor(
        enercKcal: Double?,
        procnt: Double?,
        fat: Double?,
        chocdf: Double?,
        itemTitle: String?,
        totalCalories: String?,
        dbTitle: String?
    ) {
        this.enercKcal = enercKcal
        this.procnt = procnt
        this.fat = fat
        this.chocdf = chocdf
        this.itemTitle = itemTitle
        this.totalCalories = totalCalories
        this.dbTitle = dbTitle
    }
}