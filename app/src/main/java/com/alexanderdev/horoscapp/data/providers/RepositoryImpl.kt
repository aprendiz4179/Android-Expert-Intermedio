package com.alexanderdev.horoscapp.data.providers

import android.util.Log
import com.alexanderdev.horoscapp.data.providers.network.HoroscopoApiService
import com.alexanderdev.horoscapp.data.providers.network.response.PredictionResponse
import com.alexanderdev.horoscapp.domain.model.PredictionModel
import com.alexanderdev.horoscapp.domain.model.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopoApiService):Repository {
    override suspend fun getPrediction(sign:String): PredictionModel? {
       runCatching { apiService.getHoroscopo(sign) }
           .onSuccess { return it.toDomain() }
           .onFailure { Log.i("Alex", "Ha ocurrido un error ${it.message}") }

        return null


    }
}