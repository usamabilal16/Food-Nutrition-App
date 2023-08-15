package com.example.foodnutirentapp.data.remote

import com.example.foodnutirentapp.data.entities.foodRecipesModel.DailyEatFoodRecipesModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/api/food-database/v2/parser")
    fun getEdamameFoodItems(
        @Query("app_id") app_id: String?,
        @Query("app_key") app_key: String?,
        @Query("ingr") itemName: String?,
    ): Call<DailyEatFoodRecipesModel?>
}