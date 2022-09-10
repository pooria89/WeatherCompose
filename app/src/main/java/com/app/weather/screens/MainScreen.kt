package com.app.weather.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.*
import com.app.data.model.WeatherModel
import com.app.weather.R
import com.app.weather.ui.theme.*
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        BackgroundColor,
                        BackgroundColorGradiant
                    )
                )
            )
    ) {

    }
    getPostItems()
}

fun getInformations() = listOf(
    WeatherModel(id = 1, image = R.drawable.ic_wind, title = "Wind", count = "19km/h"),
    WeatherModel(id = 2, image = R.drawable.ic_umbrella, title = "Rainfall", count = "3cm"),
    WeatherModel(id = 3, image = R.drawable.ic_humidity, title = "Humidity", count = "64%")
)

@Composable
fun getPostItems() {

    LazyColumn(
        modifier = Modifier.padding(20.dp, 0.dp, 20.dp, 7.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        item {
            val composition by rememberLottieComposition(
                LottieCompositionSpec
                    .RawRes(R.raw.weather_rainy)
            )

            val lottieAnimation by animateLottieCompositionAsState(
                composition,
                iterations = LottieConstants.IterateForever,
                speed = 1f,
                restartOnPlay = true
            )
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Column(modifier = Modifier.padding(all = 25.dp)) {
                    Text(
                        text = "Iran",
                        style = TextStyle(
                            color = TextBlackColor,
                            fontSize = 30.sp,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = "Valiasr Square",
                        style = TextStyle(
                            color = TextBlackColor,
                            fontSize = 30.sp,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = "Tue,Jan 30",
                        style = TextStyle(
                            color = TextGrayColor,
                            fontSize = 20.sp,
                            fontStyle = FontStyle.Normal,
                        )
                    )

                    Row(modifier = Modifier.padding(all = 25.dp)) {
                        LottieAnimation(
                            modifier = Modifier
                                .weight(1f)
                                .height(150.dp),
                            composition = composition,
                            progress = { lottieAnimation })
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(top = 30.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "19 °C",
                                style = TextStyle(
                                    color = TextBlackColor,
                                    fontSize = 40.sp,
                                    fontStyle = FontStyle.Normal,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                            Text(
                                text = "Rainy",
                                style = TextStyle(
                                    color = TextBlackColor,
                                    fontSize = 30.sp,
                                    fontStyle = FontStyle.Normal,
                                )
                            )
                        }
                    }

                    getInformations()
                }
            }
        }

        val items = getInformations()
        items(count = items.size) { index ->
            Card(
                backgroundColor = WhiteWithOpacityFifty,
                elevation = 0.dp,
                modifier = Modifier
                    .padding(3.dp)
                    .height(70.dp)
                    .clip(shape = RoundedCornerShape(30))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Card(
                        backgroundColor = Color.White,
                        elevation = 0.dp,
                        modifier = Modifier
                            .width(48.dp)
                            .height(48.dp)
                            .clip(shape = RoundedCornerShape(30))
                    ) {
                        Image(
                            painter = painterResource(id = items[index].image),
                            contentScale = ContentScale.Crop,
                            contentDescription = null
                        )
                    }
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(
                        text = items[index].title,
                        style = TextStyle(
                            color = TextBlackColor,
                            fontSize = 20.sp,
                            fontStyle = FontStyle.Normal,
                        )
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = items[index].count,
                        style = TextStyle(
                            color = TextBlackColor,
                            fontSize = 20.sp,
                            fontStyle = FontStyle.Normal,
                        )
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun LoadUi() {
    MainScreen()
}







