package com.codelabs.pruebatecnicaclima.di

import  com.codelabs.pruebatecnicaclima.data.api.IApiWeatherService
import com.codelabs.pruebatecnicaclima.utils.ConstantValues
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ModuleApiWeather {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ConstantValues.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideIApiCountryService(retrofit: Retrofit): IApiWeatherService {
        return retrofit.create(IApiWeatherService::class.java)
    }
}