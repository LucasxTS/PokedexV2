package com.example.feature.welcomeView.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.designsystems.components.BaseIllustratedImage
import com.example.feature.welcomeView.WelcomePage

@Composable
fun WelcomePageContent(page: WelcomePage) {
    BaseIllustratedImage(
        image = page.image,
        title = page.title,
        subtitle = page.subtitle
    )
}

@Preview
@Composable
private fun WelcomePageContentPreview() {
    WelcomePageContent(pagesList[0])
}