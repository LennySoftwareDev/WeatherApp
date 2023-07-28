package com.codelabs.pruebatecnicaclima.utils.helperscompose

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
fun ImageHelper(
    modifier: Modifier,
    @DrawableRes image: Int
){
    Image(
        painter = painterResource(id = image),
        contentDescription = "",
        modifier = modifier,
    )
}
