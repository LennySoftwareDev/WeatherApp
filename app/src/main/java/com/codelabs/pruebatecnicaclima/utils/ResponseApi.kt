package com.codelabs.pruebatecnicaclima.utils

sealed class ResponseApi<T>(
    val result: T? = null,
    val message: String? = null
) {
    class ApiResponseSuccess<T>(dataApi: T) : ResponseApi<T>(result = dataApi)

    class ApiResponseError<T>(message: String) : ResponseApi<T>(message = message)
}
