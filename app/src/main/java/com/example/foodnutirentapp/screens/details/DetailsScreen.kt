package com.example.foodnutirentapp.screens.details

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.foodnutirentapp.components.DetailsScreenContent
import com.example.foodnutirentapp.components.HeadingTextComponent
import com.example.foodnutirentapp.components.Spacer
import com.example.foodnutirentapp.ui.theme.DETAIL_SCREEN_TITLE

@Composable
fun DetailsScreen(
    navController: NavController,
    foodHint: String?,
    componentActivity: ComponentActivity
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(5.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.height(20.dp))
            HeadingTextComponent(
                value = DETAIL_SCREEN_TITLE,
                Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp)
                    .heightIn()
            )
            Spacer(modifier = Modifier.height(20.dp))

            DetailsScreenContent(
                foodHint, componentActivity
            )


        }
    }
}