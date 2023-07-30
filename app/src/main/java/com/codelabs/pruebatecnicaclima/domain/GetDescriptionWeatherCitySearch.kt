package com.codelabs.pruebatecnicaclima.domain

import com.codelabs.pruebatecnicaclima.data.model.WeatherDescriptionDto
import com.codelabs.pruebatecnicaclima.data.repository.DescriptionWeatherRepository
import com.codelabs.pruebatecnicaclima.utils.ResponseApi
import javax.inject.Inject

class GetDescriptionWeatherCitySearch @Inject constructor(
private val repository: DescriptionWeatherRepository
) {
    suspend operator fun invoke(nameCity: String): ResponseApi<WeatherDescriptionDto> {
       return repository.getWeatherInformationFromApi(nameCity)
    }
}