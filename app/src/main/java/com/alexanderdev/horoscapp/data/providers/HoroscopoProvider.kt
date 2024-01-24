package com.alexanderdev.horoscapp.data.providers

import com.alexanderdev.horoscapp.domain.model.HoroscopoInfo
import javax.inject.Inject

class HoroscopoProvider @Inject constructor() {
    fun getHoroscopos():List<HoroscopoInfo>{
        return listOf(
            HoroscopoInfo.Aries,
            HoroscopoInfo.Tauro,
            HoroscopoInfo.Geminis,
            HoroscopoInfo.Cancer,
            HoroscopoInfo.Leo,
            HoroscopoInfo.Virgo,
            HoroscopoInfo.Libra,
            HoroscopoInfo.Escorpion,
            HoroscopoInfo.Sagitario,
            HoroscopoInfo.Capricornio,
            HoroscopoInfo.Acuario,
            HoroscopoInfo.Piscis,


        )
    }
}