package com.example.feature.welcomeView.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystems.R
import com.example.designsystems.components.PrimaryButton
import kotlinx.coroutines.launch

@Composable
fun WelcomeButton(
    pagerState: PagerState,
    onFinish: () -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()
    val isLastPage = pagerState.currentPage == pagesList.size - 1

    PrimaryButton(
        modifier = Modifier.padding(16.dp),
        text = if (isLastPage) R.string.welcome_button_second_pager else R.string.welcome_button_first_pager,
        onClick = {
            if (isLastPage) {
                onFinish()
            } else {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                }
            }
        }
    )
}

@Preview
@Composable
private fun WelcomeButtonPreview() {
     val pagerState = rememberPagerState { pagesList.size }
    WelcomeButton(
        pagerState = pagerState,
        onFinish = {}
    )
}