package com.example.designsystems.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystems.R
import com.example.designsystems.buttonColor
import com.example.designsystems.white

@Composable
fun PrimaryButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    Button(
        colors = buttonColors(
            containerColor = buttonColor,
            contentColor = white
        ),
        onClick = onClick,
        enabled = enabled,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {
        Text(
            text = text,
            fontFamily = FontFamily(Font(R.font.poppins_semibold))
        )
    }
}


@Preview
@Composable
private fun BaseButtonPreview() {
    PrimaryButton(
        "Hi",
        onClick = {}
    )
}