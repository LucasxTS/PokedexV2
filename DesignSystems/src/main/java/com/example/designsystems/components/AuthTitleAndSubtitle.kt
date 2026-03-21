package com.example.designsystems.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.designsystems.R

@Composable
fun AuthTitleAndSubTitle(
    @StringRes title: Int,
    @StringRes subtitle: Int,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(title),
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.poppins_regular)),
            textAlign = TextAlign.Center,
            modifier = modifier.fillMaxWidth()
        )

        Text(
            text = stringResource(subtitle),
            fontSize = 24.sp,
            fontFamily = FontFamily(Font(R.font.poppins_medium)),
            textAlign = TextAlign.Center,
            modifier = modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
private fun AuthTitleAndSubTitlePreview() {
    AuthTitleAndSubTitle(
        title = R.string.email_component_bold_title,
        subtitle = R.string.email_component_subtitle
    )
}