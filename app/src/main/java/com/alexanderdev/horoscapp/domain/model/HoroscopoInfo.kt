package com.alexanderdev.horoscapp.domain.model

import com.alexanderdev.horoscapp.R

sealed class HoroscopoInfo(val img:Int, val name:Int) {
    data object Aries:HoroscopoInfo(R.drawable.aries, R.string.aries)
    data object Tauro:HoroscopoInfo(R.drawable.tauro, R.string.taurus)
    data object Acuario:HoroscopoInfo(R.drawable.aquario, R.string.aquarius)
    data object Cancer:HoroscopoInfo(R.drawable.cancer, R.string.cancer)
    data object Capricornio:HoroscopoInfo(R.drawable.capricornio, R.string.capricorn)
    data object Geminis:HoroscopoInfo(R.drawable.geminis, R.string.gemini)
    data object Leo:HoroscopoInfo(R.drawable.leo, R.string.leo)
    data object Libra:HoroscopoInfo(R.drawable.libra, R.string.libra)
    data object Piscis:HoroscopoInfo(R.drawable.piscis, R.string.pisces)
    data object Sagitario:HoroscopoInfo(R.drawable.sagitario, R.string.sagittarius)
    data object Escorpion:HoroscopoInfo(R.drawable.escorpio, R.string.scorpio)
    data object Virgo:HoroscopoInfo(R.drawable.virgo, R.string.virgo)
}