package com.codelabs.pruebatecnicaclima.domain

import com.codelabs.pruebatecnicaclima.data.model.WeatherDescriptionDto
import com.codelabs.pruebatecnicaclima.data.repository.DescriptionWeatherRepository
import javax.inject.Inject

class GetDescriptionWeatherCitySearch @Inject constructor(
private val repository: DescriptionWeatherRepository
) {
    suspend operator fun invoke(nameCity: String): WeatherDescriptionDto?{
        val city = repository.getWeatherInformationFromApi(nameCity)
        if (city != null) {
            return city
        }
        return null
    }
}