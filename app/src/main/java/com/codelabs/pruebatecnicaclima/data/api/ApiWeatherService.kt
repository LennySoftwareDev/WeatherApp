package com.codelabs.pruebatecnicaclima.data.api

import com.codelabs.pruebatecnicaclima.data.model.WeatherDescriptionDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ApiWeatherService @Inject constructor(private val api: IApiWeatherService) {
    suspend fun getAllWeatherInformation(nameCity: String): WeatherDescriptionDto? {
        return withContext(Dispatchers.IO) {
            val response = api.getDescriptionWeatherByCity(nameCity)
            response.body()
        }
    }
}