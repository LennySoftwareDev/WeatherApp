package com.codelabs.pruebatecnicaclima.data.api

import com.codelabs.pruebatecnicaclima.data.model.WeatherDescriptionDto
import com.codelabs.pruebatecnicaclima.utils.ConstantValues
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IApiWeatherService {

    @GET("weather")
    suspend fun getDescriptionWeatherByCity(
        @Query("q") nameCity: String,
        @Query("appid") apiKey: String = ConstantValues.API_KEY,
    ): Response<WeatherDescriptionDto>
}