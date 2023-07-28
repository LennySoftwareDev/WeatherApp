package com.codelabs.pruebatecnicaclima.utils

sealed class Routes(val routes: String) {
    object ScreenCitySearch : Routes("SearchWeatherCity")
    object ScreenDescriptionWeather : Routes("WeatherInformation")
}