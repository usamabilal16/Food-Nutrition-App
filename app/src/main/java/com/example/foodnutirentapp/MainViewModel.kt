package com.example.foodnutirentapp

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.boilerplate.utils.Resource
import com.example.foodnutirentapp.data.entities.foodItemsRequestModel.FoodRequestModel
import com.example.foodnutirentapp.data.entities.foodRecipesModel.DailyEatFoodRecipesModel
import com.example.foodnutirentapp.domain.usecases.getFoodItemsByName.GetFoodItemsByNameUseCase
import com.example.foodnutirentapp.ui.theme.FOOD_APP_ID
import com.example.foodnutirentapp.ui.theme.FOOD_APP_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    var app: Application, var getFoodItemsByNameUseCase: GetFoodItemsByNameUseCase
) : ViewModel() {
    private var _foodItemsByNameMutableLiveData = MutableLiveData<DailyEatFoodRecipesModel?>()
    var foodItemsByNameMutableLiveData: LiveData<DailyEatFoodRecipesModel?> =
        _foodItemsByNameMutableLiveData

    private suspend fun foodItemsWithName(foodItemRequestModel: FoodRequestModel) =
        getFoodItemsByNameUseCase.execute(foodItemRequestModel)


    suspend fun getFooItemsResult(foodItemRequestModel: FoodRequestModel) {
        foodItemsWithName(foodItemRequestModel).collect { resource ->
            when (resource) {
                is Resource.Success -> {
                    _foodItemsByNameMutableLiveData.postValue(resource.data)
                    Timber.d("Success")
                }

                is Resource.Loading -> {
                    // _isLoginSuccess.postValue(LOADING)
                    Timber.d("Loading")
                }

                is Resource.Error -> {
                    //_isLoginSuccess.postValue(FAILURE)

                }

            }

        }
    }
}