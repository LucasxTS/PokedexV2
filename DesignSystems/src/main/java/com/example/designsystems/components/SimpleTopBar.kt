package com.example.designsystems.components

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.designsystems.R
import com.example.designsystems.black

@Composable
fun SimpleTopBar(
    @StringRes title: Int,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {

        Icon(
            painter = painterResource(R.drawable.baseline_arrow_back_24),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 16.dp)
                .size(24.dp)
                .clickable { onBackClick() }
        )

        Text(
            text = stringResource(title),
            modifier = Modifier.align(Alignment.Center),
            fontSize = 18.sp,
            fontFamily = FontFamily(Font(R.font.poppins_semibold)),
            color = black
        )
    }
}


@Preview
@Composable
private fun TitleWithBackButtonPreview() {
    SimpleTopBar(R.string.welcome_button_first_pager, {})
}