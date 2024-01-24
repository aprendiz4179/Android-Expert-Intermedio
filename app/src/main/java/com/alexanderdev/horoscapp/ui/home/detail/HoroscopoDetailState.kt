package com.alexanderdev.horoscapp.ui.home.detail

import com.alexanderdev.horoscapp.domain.model.HoroscopoModel

sealed class HoroscopoDetailState {
    data object Loading:HoroscopoDetailState()
    data class Error(val error:String):HoroscopoDetailState()
    data class Success(val prediction:String, val sign:String, val horoscopoModel: HoroscopoModel )  :HoroscopoDetailState()
}