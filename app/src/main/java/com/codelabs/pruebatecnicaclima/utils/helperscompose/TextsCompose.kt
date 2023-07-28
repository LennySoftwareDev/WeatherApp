package com.codelabs.pruebatecnicaclima.utils.helperscompose

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit

@Composable
fun TitleHelper(
    modifier: Modifier,
    title: String,
    fontSize: TextUnit,
    fontWeight: FontWeight?,
    color: Color?
) {
    Text(
        text = title,
        fontSize = fontSize,
        fontWeight = fontWeight,
        color = color ?: Color.Black,
        modifier = modifier
    )
}
