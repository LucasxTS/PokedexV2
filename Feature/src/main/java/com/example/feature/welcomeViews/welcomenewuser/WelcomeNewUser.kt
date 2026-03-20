package com.example.feature.welcomeViews.welcomenewuser

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.navigation.Navigation
import com.example.core.navigation.NavigationController
import com.example.designsystems.R
import com.example.designsystems.components.BaseIllustratedImage
import com.example.designsystems.components.PrimaryButton
import com.example.designsystems.white

@Composable
fun WelcomeNewUser(navigation: Navigation) {
    WelcomeNewUserContent(navigateToHome = {  })
}

@Composable
fun WelcomeNewUserContent(navigateToHome: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(white)
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {

            Image(
                painter = painterResource(id = R.drawable.path),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-210).dp)
            )

            BaseIllustratedImage(
                modifier = Modifier.background(Color.Transparent),
                image = R.drawable.new_account_trainer,
                title = R.string.welcome_new_user_title,
                subtitle = R.string.welcome_new_user_subtitle
            )
        }

        PrimaryButton(
            text = R.string.welcome_new_user_button_label,
            onClick = {  }
        )
    }
}

@Preview
@Composable
private fun WelcomeNewUserPreview() {
    WelcomeNewUser(NavigationController())
}