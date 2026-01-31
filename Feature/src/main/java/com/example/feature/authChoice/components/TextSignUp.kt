package com.example.feature.authChoice.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.designsystems.R
import com.example.designsystems.blueButton

@Composable
fun SignUpText(onCLick: () -> Unit) {
    Text(
        text = stringResource(R.string.auth_choice_already_have_account),
        color = blueButton,
        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
        fontSize = 16.sp,
        modifier = Modifier.clickable { onCLick }
    )
}