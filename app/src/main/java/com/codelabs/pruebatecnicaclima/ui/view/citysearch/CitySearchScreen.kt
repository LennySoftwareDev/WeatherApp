package com.codelabs.pruebatecnicaclima.ui.view.citysearch

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.codelabs.pruebatecnicaclima.R
import com.codelabs.pruebatecnicaclima.utils.ConstantValues
import com.codelabs.pruebatecnicaclima.utils.Routes

@Composable
fun SearchWeatherCity(navController: NavController, viewModelCitySearch: ViewModelCitySearch) {
    val nameCity: String by viewModelCitySearch.nameCity.observeAsState(initial = "")
    val enabledButton: Boolean by viewModelCitySearch.isButtonSearchCityEnable.observeAsState(
        initial = false
    )

    Column(
        Modifier
            .fillMaxSize()
            .padding(32.dp),
    ) {
        TitleApp(
            Modifier
                .align(CenterHorizontally)
                .padding(bottom = 8.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.weather_forecast),
            contentDescription = "Weather",
            modifier = Modifier
                .size(400.dp)
                .align(CenterHorizontally),
        )
        Spacer(modifier = Modifier.size(16.dp))
        SearchBar(
            nameCity = nameCity,
            onTextChanged = { viewModelCitySearch.onFieldSearchCityChanged(it) },
        )
        Spacer(modifier = Modifier.size(16.dp))
        NavigateWeatherInformationCity(
            viewModelCitySearch,
            viewModelCitySearch.nameCity.value.toString(),
            navController,
            enabledButton
        )
    }
}

@Composable
fun SearchBar(
    nameCity: String,
    onTextChanged: (String) -> Unit,
) {

    Column(modifier = Modifier) {
        TextField(
            value = nameCity,
            onValueChange = { onTextChanged(it) },
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            placeholder = { Text(text = "search city") },
            maxLines = 1,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(50.dp)
        )
    }
}

@Composable
fun NavigateWeatherInformationCity(
    viewModelCitySearch: ViewModelCitySearch,
    nameCity: String,
    navController: NavController,
    isEnabledButton: (Boolean)
) {
    Button(
        onClick = {
            viewModelCitySearch.getInformationWheater(nameCity)
            navController.navigate(Routes.Screen2.routes)
        },
        enabled = isEnabledButton,
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF4EA8E9),
            disabledBackgroundColor = Color(0xFF78C8F9),
            contentColor = Color.White,
            disabledContentColor = Color.White
        ),
        shape = RoundedCornerShape(50.dp)
        ) {
        Text(text = "Search")
    }
}

@Composable
fun TitleApp(modifier: Modifier){
    Text(
        text = ConstantValues.APP_TITLE,
        fontSize = 36.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF4EA8E9),
        modifier = modifier
    )
}