package com.example.foodnutirentapp.data.repo

import com.example.foodnutirentapp.data.remote.ApiService
import com.example.foodnutirentapp.domain.repository.RemoteRepository
import com.example.foodnutirentapp.data.entities.foodRecipesModel.DailyEatFoodRecipesModel
import retrofit2.Call
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    RemoteRepository {
    override suspend fun getFoodItemsByName(
        appId: String?,
        appKey: String?,
        itemName: String?
    ): Call<DailyEatFoodRecipesModel?> {
        return apiService.getEdamameFoodItems(appId, appKey, itemName)
    }


}