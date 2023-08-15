package com.example.foodnutirentapp.widgets

import androidx.activity.ComponentActivity
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.foodnutirentapp.R
import com.example.foodnutirentapp.components.BoldTextComponent
import com.example.foodnutirentapp.components.BoldWithNormalTextComponent
import com.example.foodnutirentapp.data.entities.foodRecipesModel.Hint
import com.example.foodnutirentapp.ui.theme.Purple40
import com.example.foodnutirentapp.ui.theme.colorText

@Preview
@Composable
fun FoodRow(
    food: Hint = Hint(),
    componentActivity: ComponentActivity,
    isExpended: Boolean = false,
    onItemClick: (String?) -> Unit = {}

) {

    var expanded by remember {
        mutableStateOf(isExpended)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(6.dp)
            .clickable {
                onItemClick(food.food?.foodId)
            },
        colors = CardDefaults.elevatedCardColors(Color.White),
        shape = RoundedCornerShape(CornerSize(6.dp)),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {

            Surface(
                modifier = Modifier
                    .size(100.dp)
                    .padding(12.dp),
                shape = RectangleShape,
                shadowElevation = 0.dp
            ) {

                Image(
                    painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(LocalContext.current).data(food.food?.image)
                            .crossfade(true).transformations(CircleCropTransformation()).build()
                    ), contentDescription = "Image", alignment = Alignment.TopCenter
                )
            }
            Column(modifier = Modifier.padding(4.dp)) {
                BoldTextComponent(
                    value = food.food?.label ?: "", TextStyle(
                        fontSize = 16.sp, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Normal
                    ), Purple40, TextAlign.Start
                )
                BoldWithNormalTextComponent(
                    boldValue = componentActivity.getString(R.string.category),
                    normalValue = food.food?.category ?: ""
                )
                BoldWithNormalTextComponent(
                    boldValue = componentActivity.getString(R.string.category_label),
                    normalValue = food.food?.categoryLabel ?: ""
                )
                Icon(imageVector = if (!expanded) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowUp,
                    contentDescription = "Arrow Down",
                    Modifier
                        .clickable { expanded = !expanded }
                        .size(25.dp),
                    tint = Color.DarkGray)

                AnimatedVisibility(visible = expanded) {
                    Column(Modifier.padding(bottom = 6.dp)) {
                        Text(buildAnnotatedString {

                            withStyle(style = SpanStyle(color = Color.DarkGray, fontSize = 13.sp)) {
                                append("Plot: ")
                            }

                            withStyle(
                                style = SpanStyle(
                                    color = Color.DarkGray,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Light
                                )
                            ) {
                                append("${food.food?.nutrients?.chocdf}")
                            }
                        }, modifier = Modifier.padding(6.dp))

                        Divider(Modifier.padding(6.dp))
                        BoldWithNormalTextComponent(
                            boldValue = "Energy: \nProtein: \nFat: \nCarbohydrate: \nFiber: \n",
                            "${food.food?.nutrients?.enercKcal} KCal\n${food.food?.nutrients?.procnt} g\n${food.food?.nutrients?.fat} g\n${food.food?.nutrients?.chocdf} g\n${food.food?.nutrients?.fibtg} g\n"
                        )
                        BoldWithNormalTextComponent(
                            boldValue = componentActivity.getString(R.string.measures),
                            normalValue = "${food.measures?.get(0)?.weight} ${
                                food.measures?.get(
                                    0
                                )?.label
                            }"
                        )
                    }
                }
            }
        }
    }
}