package com.alexanderdev.horoscapp.domain.model

interface Repository {
    suspend fun getPrediction(sign:String):PredictionModel?
}