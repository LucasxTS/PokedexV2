package com.example.feature.createAccount.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.designsystems.R

@Composable
fun EmailStep(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    BaseAccountSteps(
        modifier = modifier,
        title = R.string.email_component_title,
        subtitle = R.string.email_component_bold_title,
        placeholder = R.string.email_component_input_field_placeholder,
        hint = R.string.email_component_subtitle,
        value = value,
        onValueChange = onValueChange,
        keyboardType = KeyboardType.Email
    )
}

@Preview
@Composable
private fun EmailStepPreview() {
    EmailStep(value = "", onValueChange = {})
}