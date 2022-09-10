package com.app.weather.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.weather.R
import com.app.weather.ui.theme.BackgroundColor


@Composable
fun Toolbar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(BackgroundColor)
            .height(56.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier.padding(start = 10.dp, end = 10.dp)
        ) {
            Image(
                painter = painterResource(
                    id = R.drawable.ic_search
                ),
                contentDescription = ""
            )
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(
                    id = R.drawable.ic_more
                ),
                contentDescription = ""
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Toolbar()
}

