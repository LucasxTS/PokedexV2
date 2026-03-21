package com.example.feature.createAccount.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.designsystems.R
import com.example.designsystems.components.AuthTextField
import com.example.designsystems.components.AuthTitleAndSubTitle
import com.example.designsystems.components.HintComponent

@Composable
fun EmailStep(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        AuthTitleAndSubTitle(
            title = R.string.email_component_bold_title,
            subtitle = R.string.email_component_subtitle,
            modifier = modifier
        )
        AuthTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = R.string.email_component_input_field_placeholder,
            keyboardType = KeyboardType.Email,
            isRegister = true,
        )
        HintComponent(
            hint = R.string.email_component_subtitle,
            modifier = modifier
        )
    }
}

@Preview
@Composable
private fun EmailStepPreview() {
    EmailStep(value = "", onValueChange = {})
}