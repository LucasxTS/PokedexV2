package com.example.feature.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.navigation.Navigation
import com.example.core.navigation.NavigationController
import com.example.designsystems.R
import com.example.designsystems.components.BaseIllustratedImage
import com.example.designsystems.components.GoogleSignInButton
import com.example.designsystems.components.PrimaryButton
import com.example.designsystems.components.SimpleTopBar
import com.example.designsystems.white
import com.example.di.viewModel

@Composable
fun RegisterScreen(navigation: Navigation, registerScreenViewModel: RegisterScreenViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(white)
    )
    {
        SimpleTopBar(
            modifier = Modifier.padding(16.dp),
            title = R.string.register_header_title,
            onBackClick = { navigation.pop() }
        )
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            BaseIllustratedImage(
                image = R.drawable.register_img,
                title = R.string.register_title_label,
                subtitle = R.string.register_subtitle_label
            )
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .padding(16.dp)
        ) {
            GoogleSignInButton(
                onClick = {
                    registerScreenViewModel.continueWithGoogle()
                }
            )

            PrimaryButton(
                text = R.string.register_button_title,
            ) {

            }
        }
    }
}

@Preview
@Composable
private fun RegisterScreenPreview() {
//    RegisterScreen(
//        navigation = NavigationController(),
//        registerScreenViewModel =
//    )
}