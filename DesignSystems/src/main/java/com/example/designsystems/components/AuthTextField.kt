package com.example.designsystems.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.designsystems.R
import com.example.designsystems.gray600

@Composable
fun AuthTextField(
    value: String,
    modifier: Modifier = Modifier,
    isPassword: Boolean = false,
    @StringRes placeholder: Int,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text,
    isRegister: Boolean
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
        .fillMaxWidth()
        .padding(16.dp)
    ) {
        if (!isRegister) {
            Text(
                text = stringResource(placeholder),
                fontSize = 16.sp,
                color = gray600,
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
            )
        }

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = { Text(stringResource(placeholder)) },
            singleLine = true,
            visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            modifier = modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
private fun AuthTextFieldPreview() {
    AuthTextField(
        value = "",
        placeholder = R.string.email_component_input_field_placeholder,
        onValueChange = {},
        isRegister = false
    )
}