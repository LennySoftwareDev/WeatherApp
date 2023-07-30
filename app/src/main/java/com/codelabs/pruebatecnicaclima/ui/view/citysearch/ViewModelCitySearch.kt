package com.codelabs.pruebatecnicaclima.ui.view.citysearch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codelabs.pruebatecnicaclima.data.model.WeatherDescriptionDto
import com.codelabs.pruebatecnicaclima.domain.GetDescriptionWeatherCitySearch
import com.codelabs.pruebatecnicaclima.utils.ResponseApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelCitySearch @Inject constructor(
    private val getDescriptionWeather: GetDescriptionWeatherCitySearch
) : ViewModel() {

    private val _city = MutableLiveData<ResponseApi<WeatherDescriptionDto>>()
    val city: LiveData<ResponseApi<WeatherDescriptionDto>> = _city

    private val _nameCity = MutableLiveData<String>()
    val nameCity: LiveData<String> = _nameCity

    private val _isButtonSearchCityEnable = MutableLiveData<Boolean>()
    val isButtonSearchCityEnable: LiveData<Boolean> = _isButtonSearchCityEnable

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getInformationWeather(nameCitySearch: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _nameCity.value = nameCitySearch
            val weatherDetails = getDescriptionWeather.invoke(nameCitySearch)
            _city.value = weatherDetails
            _isLoading.value = _city.value?.result == null
        }
    }

    fun onFieldSearchCityChanged(city: String) {
        _nameCity.value = city
        _isButtonSearchCityEnable.value = _nameCity.value?.length!! > 0
    }
}