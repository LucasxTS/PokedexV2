package com.example.designsystems.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.designsystems.R
import com.example.designsystems.blueButton
import com.example.designsystems.white

@Composable
fun PrimaryButton(
    @StringRes text: Int,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    Button(
        colors = buttonColors(
            containerColor = blueButton,
            contentColor = white
        ),
        onClick = onClick,
        enabled = enabled,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {
        Text(
            text = stringResource(text),
            fontFamily = FontFamily(Font(R.font.poppins_semibold)),
            fontSize = 16.sp
        )
    }
}


@Preview
@Composable
private fun BaseButtonPreview() {
    PrimaryButton(
        R.string.auth_choice_create_account_button,
        onClick = {}
    )
}