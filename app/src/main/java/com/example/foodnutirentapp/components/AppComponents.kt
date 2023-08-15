package com.example.foodnutirentapp.components

import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasurePolicy
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.foodnutirentapp.MainViewModel
import com.example.foodnutirentapp.data.entities.foodItemsRequestModel.FoodRequestModel
import com.example.foodnutirentapp.data.entities.foodRecipesModel.Hint
import com.example.foodnutirentapp.navigation.FoodItemsScreens
import com.example.foodnutirentapp.ui.theme.FOOD_APP_ID
import com.example.foodnutirentapp.ui.theme.FOOD_APP_KEY
import com.example.foodnutirentapp.ui.theme.colorText
import com.example.foodnutirentapp.widgets.FoodRow


val foodList = mutableStateListOf<Hint>()

@Composable
@NonRestartableComposable
fun Spacer(modifier: Modifier) {
    Layout({}, measurePolicy = SpacerMeasurePolicy, modifier = modifier)
}

private object SpacerMeasurePolicy : MeasurePolicy {

    override fun MeasureScope.measure(
        measurables: List<Measurable>, constraints: Constraints
    ): MeasureResult {
        return with(constraints) {
            val width = if (hasFixedWidth) maxWidth else 0
            val height = if (hasFixedHeight) maxHeight else 0
            layout(width, height) {}
        }
    }
}

@Composable
fun NormalTextComponent(value: String) {
    Text(
        text = value, modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp), style = TextStyle(
            fontSize = 24.sp, fontWeight = FontWeight.Normal, fontStyle = FontStyle.Normal
        ), color = colorText, textAlign = TextAlign.Center
    )
}

@Composable
fun BoldTextComponent(
    value: String, textStyle: TextStyle, color: Color, textAlign: TextAlign?
) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = textStyle,
        color = color,
        textAlign = textAlign
    )
}

@Composable
fun BoldWithNormalTextComponent(boldValue: String, normalValue: String) {
    Row(Modifier.fillMaxSize()) {
        Text(
            text = boldValue, modifier = Modifier.heightIn(), style = TextStyle(
                fontSize = 14.sp, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Normal
            ), color = colorText, textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = normalValue, modifier = Modifier

                .heightIn(), style = TextStyle(
                fontSize = 14.sp, fontWeight = FontWeight.Normal, fontStyle = FontStyle.Normal
            ), color = colorText, textAlign = TextAlign.Start
        )
    }

}

@Composable
fun HeadingTextComponent(value: String, modifier: Modifier) {
    Text(
        text = value, modifier = modifier, style = TextStyle(
            fontSize = 30.sp, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Normal
        ), color = colorText, textAlign = TextAlign.Start
    )

}

@Composable
fun MainHomeScreenContent(
    navController: NavController, componentActivity: ComponentActivity
) {
    val mainViewModel: MainViewModel = hiltViewModel()/*val foodList = remember {
        mutableStateListOf<Hint>()
    }*/
    LaunchedEffect(mainViewModel.getFoodItemsByNameUseCase) {
        mainViewModel.getFooItemsResult(FoodRequestModel(FOOD_APP_ID, FOOD_APP_KEY, "Eggs"))
    }

    LaunchedEffect(mainViewModel.foodItemsByNameMutableLiveData) {
        mainViewModel.foodItemsByNameMutableLiveData.observe(componentActivity) {
            it?.hints?.let { it1 -> foodList.addAll(it1) }
        }
    }

    Column(modifier = Modifier.padding(10.dp)) {
        LazyColumn {
            items(foodList) {
                FoodRow(food = it, componentActivity, isExpended = false) { food ->
                    Toast.makeText(componentActivity, "clicked foo", Toast.LENGTH_SHORT).show()
                    navController.navigate(route = FoodItemsScreens.DetailsScreen.name + "/$food")
                }
            }
        }

    }
}

@Composable
fun DetailsScreenContent(foodId: String?, componentActivity: ComponentActivity) {
    Log.d("foodResponseLogcat", "DetailsScreenContent: $foodId ${foodList[0].food?.foodId}")
    val newfoodList = remember {
        mutableStateListOf<Hint>()
    }
    foodList.map {
        if (it.food?.foodId == foodId)
            newfoodList.add(it)
    }
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // val foodModel = foodList.single { food -> food.food?.foodId == foodId }
            LazyColumn {
                items(newfoodList) {
                    FoodRow(food = it, componentActivity, isExpended = true)
                }
            }


            /*Text(
                text = "${foodModel.food?.label} Images",
                Modifier.padding(6.dp),
                style = MaterialTheme.typography.subtitle2
            )*/

            // HorizontalScrollableImageView(movie)
        }
    }

}