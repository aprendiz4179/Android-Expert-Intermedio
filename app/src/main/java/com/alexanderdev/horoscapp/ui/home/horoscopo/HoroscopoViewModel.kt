package com.alexanderdev.horoscapp.ui.home.horoscopo

import androidx.lifecycle.ViewModel
import com.alexanderdev.horoscapp.data.providers.HoroscopoProvider
import com.alexanderdev.horoscapp.domain.model.HoroscopoInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopoViewModel @Inject constructor(  horoscopoProvider: HoroscopoProvider):ViewModel() {

    private var _horoscopo = MutableStateFlow<List<HoroscopoInfo>>(emptyList())
    val horoscopo:StateFlow<List<HoroscopoInfo>> = _horoscopo

    init{
        horoscopoProvider.getHoroscopos()
        _horoscopo.value = horoscopoProvider.getHoroscopos()
    }
}

