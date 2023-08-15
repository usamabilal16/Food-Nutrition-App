package com.example.foodnutirentapp.navigation

enum class FoodItemsScreens {

    HomeScreen,
    DetailsScreen;

    companion object{

        fun fromRoute(route: String?): FoodItemsScreens =
            when(route?.substringBefore("/")){
                HomeScreen.name -> HomeScreen
                DetailsScreen.name -> DetailsScreen
                null -> HomeScreen
                else -> throw IllegalArgumentException("Route $route is not recognised")
            }
    }

}