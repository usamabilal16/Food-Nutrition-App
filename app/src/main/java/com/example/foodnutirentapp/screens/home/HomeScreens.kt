package com.example.foodnutirentapp.screens.home

import android.content.Context
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.foodnutirentapp.components.HeadingTextComponent
import com.example.foodnutirentapp.components.MainHomeScreenContent
import com.example.foodnutirentapp.components.NormalTextComponent
import com.example.foodnutirentapp.components.Spacer
import com.example.foodnutirentapp.ui.theme.appName
import com.example.foodnutirentapp.ui.theme.colorText

@Preview
@Composable
fun HomeScreen(
    navController: NavController, componentActivity: ComponentActivity
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
                value = appName,
                Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp)
                    .heightIn()
            )
            Spacer(modifier = Modifier.height(20.dp))
            MainHomeScreenContent(
                navController = navController, componentActivity = componentActivity
            )

        }
    }
}
