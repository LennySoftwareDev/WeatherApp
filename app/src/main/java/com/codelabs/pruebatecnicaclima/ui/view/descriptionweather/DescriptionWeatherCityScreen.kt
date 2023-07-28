package com.codelabs.pruebatecnicaclima.ui.view.descriptionweather

import android.os.Build
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.codelabs.pruebatecnicaclima.R
import com.codelabs.pruebatecnicaclima.ui.view.citysearch.ViewModelCitySearch
import com.codelabs.pruebatecnicaclima.utils.ConstantValues
import com.codelabs.pruebatecnicaclima.utils.Routes
import com.codelabs.pruebatecnicaclima.utils.helperscompose.ImageHelper
import com.codelabs.pruebatecnicaclima.utils.helperscompose.TitleHelper

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherInformation(viewModelCitySearch: ViewModelCitySearch, navController: NavController) {

    val city = viewModelCitySearch.city.observeAsState().value
    val isLoading: Boolean by viewModelCitySearch.isLoading.observeAsState(initial = false)

    if (isLoading) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            ImageHelper(
                modifier = Modifier
                    .size(300.dp)
                    .align(Alignment.CenterHorizontally),
                image = R.drawable.viento
            )
            Spacer(modifier = Modifier.size(20.dp))
            Text(
                text = ConstantValues.ERROR_MESSAGE,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.size(20.dp))
            CircularProgressIndicator()
            Spacer(modifier = Modifier.size(20.dp))
            NavigateBackSearchCity(navController)
        }
    } else {
        Column(
            Modifier
                .fillMaxSize()
                .padding(32.dp)
        ) {
            SubtitleApp(
                Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 8.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.clima),
                contentDescription = "",
                modifier = Modifier
                    .size(300.dp)
                    .align(Alignment.CenterHorizontally),
            )
            Spacer(modifier = Modifier.height(30.dp))
            InformationDistribution(
                R.drawable.ubicacion,
                ("Ciudad: " + city?.name.toString()),
                Color.Black
            )
            Spacer(modifier = Modifier.size(10.dp))
            SeparateInformation()
            InformationDistribution(
                icon = R.drawable.temperatura,
                text = "Temperatura Actual: " + city?.main?.temp.toString() + "°C",
                Color.Blue
            )
            Spacer(modifier = Modifier.size(10.dp))
            SeparateInformation()
            InformationDistribution(
                icon = R.drawable.sensacion_termica,
                text = "Sensación Térmica: " + city?.main?.feels_like.toString() + "°C",
                Color.Red
            )
            Spacer(modifier = Modifier.size(10.dp))
            SeparateInformation()
            InformationDistribution(
                icon = R.drawable.humedad,
                text = "Humedad: " + city?.main?.humidity.toString() + "%",
                Color.LightGray
            )
            Spacer(modifier = Modifier.height(30.dp))
            NavigateBackSearchCity(navController)
        }
    }
}

@Composable
fun NavigateBackSearchCity(
    navController: NavController,
) {
    Button(
        onClick = {
            navController.navigate(Routes.ScreenCitySearch.routes)
        },
        enabled = true,
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
        Text(text = "Back")
    }
}

@Composable
fun SeparateInformation() {
    Divider(
        Modifier
            .fillMaxWidth()
            .padding(top = 16.dp), color = Color(0xFF4EA8E9)
    )
}

@Composable
fun InformationDistribution(
    @DrawableRes icon: Int,
    text: String,
    color: Color
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 16.dp,
        backgroundColor = Color.Transparent,
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Icon(
                painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier
                    .size(28.dp)
                    .padding(5.dp),
                tint = color,
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                text = text,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4EA8E9),
                fontSize = 24.sp
            )
        }
    }
}

@Composable
fun SubtitleApp(modifier: Modifier) {
    TitleHelper(
        modifier = modifier,
        title = ConstantValues.APP_SUBTITLE,
        fontSize = 36.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF4EA8E9)
    )
}