package com.example.feature.createAccount.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.designsystems.R

@Composable
fun NameStep(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    BaseAccountSteps(
        modifier = modifier,
        title = R.string.name_component_title,
        subtitle = R.string.name_component_bold_title,
        placeholder = R.string.name_component_input_field_placeholder,
        hint = R.string.name_component_subtitle,
        value = value,
        onValueChange = onValueChange,
        keyboardType = KeyboardType.Text
    )
}

@Preview
@Composable
private fun NameStepPreview() {
    NameStep(value = "", onValueChange = {})
}