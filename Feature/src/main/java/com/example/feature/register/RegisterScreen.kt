package com.example.feature.register

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.designsystems.R
import com.example.designsystems.components.SimpleTopBar

@Composable
fun RegisterScreen(modifier: Modifier = Modifier) {
    Column {
        SimpleTopBar(
            title = R.string.register_create_account_title,
            onBackClick = {}
        )
    }
}

@Preview
@Composable
private fun RegisterScreenPreview() {
    RegisterScreen()
}