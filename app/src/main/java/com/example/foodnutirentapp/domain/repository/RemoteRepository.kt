package com.example.foodnutirentapp.domain.repository

import com.example.foodnutirentapp.data.entities.foodRecipesModel.DailyEatFoodRecipesModel
import retrofit2.Call

interface RemoteRepository {

    suspend fun getFoodItemsByName(
        appId: String?,
        appKey: String?,
        itemName: String?,
    ): Call<DailyEatFoodRecipesModel?>

}