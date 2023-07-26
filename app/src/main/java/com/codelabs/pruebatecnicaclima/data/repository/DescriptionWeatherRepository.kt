package com.codelabs.pruebatecnicaclima.data.repository

import com.codelabs.pruebatecnicaclima.data.api.ApiWeatherService
import com.codelabs.pruebatecnicaclima.data.model.WeatherDescriptionDto
import javax.inject.Inject

class DescriptionWeatherRepository @Inject constructor(private val api: ApiWeatherService) {
    suspend fun getWeatherInformationFromApi(nameCity: String): WeatherDescriptionDto? {
        return api.getAllWeatherInformation(nameCity)
    }
}