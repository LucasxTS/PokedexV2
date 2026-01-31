package com.example.feature.authChoice.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.designsystems.R
import com.example.designsystems.black

@Composable
fun SkipAction(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Pular",
            color = black,
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.poppins_medium)),
        )

        Spacer(modifier = Modifier.width(8.dp))

        Icon(
            painter = painterResource(R.drawable.baseline_arrow_forward_24),
            contentDescription = null,
            modifier = Modifier.size(20.dp)
        )
    }
}

@Preview
@Composable
private fun SkipActionPreview() {
    SkipAction(
        onClick = {}
    )
}
