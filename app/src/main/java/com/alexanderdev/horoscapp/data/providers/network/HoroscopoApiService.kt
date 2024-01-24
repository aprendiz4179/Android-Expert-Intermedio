package com.alexanderdev.horoscapp.data.providers.network

import com.alexanderdev.horoscapp.data.providers.network.response.PredictionResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface HoroscopoApiService {

    @GET("/{sign}")
    suspend fun getHoroscopo(@Path("sign")sign:String):PredictionResponse


}