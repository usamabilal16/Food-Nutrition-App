package com.example.foodnutirentapp.domain.usecases.getFoodItemsByName

import com.android.boilerplate.utils.Resource
import com.example.foodnutirentapp.data.entities.foodItemsRequestModel.FoodRequestModel
import com.example.foodnutirentapp.di.IoDispatcher
import com.example.foodnutirentapp.domain.repository.RemoteRepository
import com.example.foodnutirentapp.data.entities.foodRecipesModel.DailyEatFoodRecipesModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class GetFoodItemsByNameUseCase @Inject constructor(
    private val remoteRepository: RemoteRepository,
    @IoDispatcher var coroutineDispatcher: CoroutineDispatcher
) {
    suspend fun execute(foodRequestModel: FoodRequestModel) =
        callbackFlow<Resource<DailyEatFoodRecipesModel?>> {
            remoteRepository.getFoodItemsByName(
                foodRequestModel.appId,
                foodRequestModel.appKey,
                foodRequestModel.itemName
            ).enqueue(object : Callback<DailyEatFoodRecipesModel?> {
                override fun onResponse(
                    call: Call<DailyEatFoodRecipesModel?>,
                    response: Response<DailyEatFoodRecipesModel?>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        trySend(Resource.Success(response.body()))

                    }
                }

                override fun onFailure(call: Call<DailyEatFoodRecipesModel?>, error: Throwable) {
                    error.message.let {
                        it?.let { it1 ->
                            Resource.Error<DailyEatFoodRecipesModel>(
                                errorMessage = it1
                            )
                        }
                    }
                }

            })

            awaitClose()
        }.flowOn(coroutineDispatcher)
}