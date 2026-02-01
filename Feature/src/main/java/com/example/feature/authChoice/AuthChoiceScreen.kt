package com.example.feature.authChoice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.navigation.NavKeys
import com.example.core.navigation.Navigation
import com.example.core.navigation.NavigationController
import com.example.designsystems.R
import com.example.designsystems.components.BaseIllustratedImage
import com.example.designsystems.components.PrimaryButton
import com.example.designsystems.white
import com.example.feature.authChoice.components.SignUpText
import com.example.feature.authChoice.components.SkipAction

@Composable
fun AuthChoiceScreen(navigation: Navigation) {
    Column(
        Modifier
            .fillMaxSize()
            .background(white)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            SkipAction {

            }
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            BaseIllustratedImage(
                image = R.drawable.auth_choice_image,
                title = R.string.auth_choice_title,
                subtitle = R.string.auth_choice_subtitle
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 48.dp)
        ) {
            PrimaryButton(
                modifier = Modifier.padding(16.dp),
                text = R.string.auth_choice_create_account_button,
                onClick = {
                    navigation.navigateTo(NavKeys.RegisterScreen)
                }
            )
            Spacer(modifier = Modifier.height(16.dp))

            SignUpText {
                navigation.navigateTo(NavKeys.LoginScreen)
            }
        }
    }
}


@Preview
@Composable
private fun AuthChoiceScreenPreview() {
    AuthChoiceScreen(navigation = NavigationController())
}