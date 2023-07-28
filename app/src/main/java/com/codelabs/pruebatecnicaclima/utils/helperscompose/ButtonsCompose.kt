package com.codelabs.pruebatecnicaclima.utils.helperscompose

import android.graphics.Color
import android.graphics.DashPathEffect
import android.util.Size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable
fun ButtonHelper(
    modifier: Modifier, 
    color: Color?, 
    text: String,
    size: Dp?
) {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            
        ),
        shape = RoundedCornerShape(size ?: 0.dp)
    ) {
        Text(text = text)
    }
}