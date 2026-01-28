package com.example.feature.welcomeView.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.designsystems.R
import com.example.designsystems.gray600
import com.example.designsystems.white
import com.example.feature.welcomeView.WelcomePage

@Composable
fun WelcomePageContent(page: WelcomePage) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp),
        modifier = Modifier
            .background(white)
            .padding(24.dp)
    ) {
        Image(
            painter = painterResource(page.image),
            contentDescription = null,
            modifier = Modifier
                .size(320.dp)
        )

        Text(
            text = stringResource(page.title),
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.poppins_medium)),
            fontSize = 32.sp,
            textAlign = TextAlign.Center,
        )

        Text(
            text = stringResource(page.subtitle),
            fontSize = 16.sp,
            color = gray600,
            fontFamily = FontFamily(Font(R.font.poppins_regular)),
            textAlign = TextAlign.Center,
        )
    }
}

@Preview
@Composable
private fun WelcomePageContentPreview() {
    WelcomePageContent(pagesList[0])
}