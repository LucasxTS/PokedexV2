package com.example.feature.welcomeView

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.navigation.Navigation
import com.example.core.navigation.NavigationController
import com.example.designsystems.white
import com.example.feature.welcomeView.components.PagerIndicator
import com.example.feature.welcomeView.components.WelcomeButton
import com.example.feature.welcomeView.components.WelcomePageContent
import com.example.feature.welcomeView.components.pagesList

@Composable
fun WelcomeScreen(navigation: Navigation) {
    val pagerState = rememberPagerState { pagesList.size }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(white)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.BottomStart
        ) {
            HorizontalPager(
                state = pagerState
            ) { page ->
                WelcomePageContent(page = pagesList[page])
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            PagerIndicator(
                pageCount = pagesList.size,
                currentPage = pagerState.currentPage,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            WelcomeButton(
                pagerState = pagerState,
                onFinish = { }
            )
        }
    }
}


@Preview
@Composable
private fun WelcomeScreenPreview() {
    WelcomeScreen(navigation = NavigationController())
}