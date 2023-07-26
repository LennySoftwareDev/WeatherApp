package com.codelabs.pruebatecnicaclima.utils

sealed class Routes(val routes: String) {
    object Screen1 : Routes("SearchWeatherCity")
    object Screen2 : Routes("WeatherInformation")
}