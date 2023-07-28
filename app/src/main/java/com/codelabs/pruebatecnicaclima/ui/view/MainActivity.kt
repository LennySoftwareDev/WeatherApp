package com.codelabs.pruebatecnicaclima.ui.view

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.codelabs.pruebatecnicaclima.theme.PruebaTecnicaClimaTheme
import com.codelabs.pruebatecnicaclima.ui.view.citysearch.SearchWeatherCity
import com.codelabs.pruebatecnicaclima.ui.view.citysearch.ViewModelCitySearch
import com.codelabs.pruebatecnicaclima.ui.view.descriptionweather.WeatherInformation
import com.codelabs.pruebatecnicaclima.utils.Routes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModelCitySearch: ViewModelCitySearch by viewModels()
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PruebaTecnicaClimaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.ScreenCitySearch.routes
                    ) {
                        composable(Routes.ScreenCitySearch.routes) {
                            SearchWeatherCity(
                                navController = navigationController,
                                viewModelCitySearch = viewModelCitySearch
                            )
                        }
                        composable(Routes.ScreenDescriptionWeather.routes) {
                            WeatherInformation(
                                navController = navigationController,
                                viewModelCitySearch = viewModelCitySearch
                            )
                        }
                    }
                }
            }
        }
    }
}
