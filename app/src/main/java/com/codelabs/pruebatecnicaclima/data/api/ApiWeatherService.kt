package com.codelabs.pruebatecnicaclima.data.api

import com.codelabs.pruebatecnicaclima.data.model.WeatherDescriptionDto
import com.codelabs.pruebatecnicaclima.utils.ResponseApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ApiWeatherService @Inject constructor(private val api: IApiWeatherService) {
    suspend fun getAllWeatherInformation(nameCity: String): ResponseApi<WeatherDescriptionDto> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.getDescriptionWeatherByCity(nameCity)
                if (response.isSuccessful) {
                    ResponseApi.ApiResponseSuccess(dataApi = response.body()!!)
                } else {
                    ResponseApi.ApiResponseError(message = response.message())
                }
            } catch (e: HttpException) {
                ResponseApi.ApiResponseError(message = e.message())
            } catch (e:IOException) {
                ResponseApi.ApiResponseError(message = "Please check your network connection")
            } catch (e:Exception){
                ResponseApi.ApiResponseError(message = e.message.toString())
            }
        }
    }
}