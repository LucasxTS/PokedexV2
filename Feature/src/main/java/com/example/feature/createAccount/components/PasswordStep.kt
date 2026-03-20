package com.example.feature.createAccount.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.designsystems.R

@Composable
fun PasswordStep(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    BaseAccountSteps(
        modifier = modifier,
        title = R.string.password_component_title,
        subtitle = R.string.password_component_bold_title,
        placeholder = R.string.password_component_input_field_placeholder,
        hint = R.string.password_component_subtitle,
        value = value,
        onValueChange = onValueChange,
        keyboardType = KeyboardType.Password,
        isPassword = true
    )
}

@Preview
@Composable
private fun PasswordStepPreview() {
    PasswordStep(value = "", onValueChange = {})
}