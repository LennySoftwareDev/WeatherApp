package com.codelabs.pruebatecnicaclima.utils.helperscompose

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ButtonHelper(
    modifier: Modifier,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    text: String,
    sizeRoundedCornerShape: Dp?,
    isEnabled: Boolean,
    onClick: () -> Unit
) {
    Button(
        onClick = {
            onClick()
        },
        modifier = modifier,
        colors = colors,
        shape = RoundedCornerShape(sizeRoundedCornerShape ?: 0.dp),
        enabled = isEnabled
    ) {
        Text(text = text)
    }
}