package com.example.feature.createAccount.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.designsystems.R
import com.example.designsystems.gray600

@Composable
fun BaseAccountSteps(
    modifier: Modifier = Modifier,
    @StringRes title: Int,
    @StringRes subtitle: Int,
    @StringRes placeholder: Int,
    @StringRes hint: Int,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPassword: Boolean = false
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        ) {
        Text(
            text = stringResource(title),
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.poppins_regular)),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = stringResource(subtitle),
            fontSize = 24.sp,
            fontFamily = FontFamily(Font(R.font.poppins_medium)),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = { Text(stringResource(placeholder)) },
            singleLine = true,
            visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = stringResource(hint),
            fontSize = 12.sp,
            color = gray600,
            fontFamily = FontFamily(Font(R.font.poppins_regular)),
        )
    }
}

@Preview
@Composable
private fun EmailFieldPreview() {
    BaseAccountSteps(
        title = R.string.email_component_title,
        subtitle = R.string.email_component_bold_title,
        value = "",
        onValueChange = {},
        placeholder = R.string.email_component_input_field_placeholder,
        hint = R.string.email_component_subtitle
    )
}