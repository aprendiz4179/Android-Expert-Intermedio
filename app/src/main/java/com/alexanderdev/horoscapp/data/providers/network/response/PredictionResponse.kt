package com.alexanderdev.horoscapp.data.providers.network.response

import com.alexanderdev.horoscapp.domain.model.PredictionModel
import com.google.gson.annotations.SerializedName
import java.util.Date

data class PredictionResponse(
    @SerializedName("date") val date: String,
    @SerializedName("horoscope") val horoscope: String,
    @SerializedName("sign") val sign: String,

){
    fun toDomain():PredictionModel{
        return PredictionModel(
            horoscope = horoscope,
            sign = sign
        )

    }
}
