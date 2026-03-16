package com.example.designsystems.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystems.R
import com.example.designsystems.backgroundSplashColor
import kotlinx.coroutines.delay

@Composable
fun LoadingScreen() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundSplashColor),

    ) {
        LoadingImages()
    }
}

@Composable
fun LoadingImages() {
    var currentFrame by remember { mutableIntStateOf(0) }

    val frames = listOf(
        R.drawable.v1,
        R.drawable.v4,
        R.drawable.v3,
        R.drawable.v2
    )

    LaunchedEffect(Unit) {
        while (true) {
            delay(120)
            currentFrame = (currentFrame + 1) % frames.size
        }
    }

    Image(
        painter = painterResource(id = frames[currentFrame]),
        contentDescription = "Loading",
        modifier = Modifier.size(48.dp)
    )
}

@Preview
@Composable
private fun LoadingScreenPreview() {
    LoadingScreen()
}