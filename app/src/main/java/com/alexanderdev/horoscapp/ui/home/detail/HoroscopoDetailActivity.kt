package com.alexanderdev.horoscapp.ui.home.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.alexanderdev.horoscapp.R
import com.alexanderdev.horoscapp.databinding.ActivityHoroscopoDetailBinding
import com.alexanderdev.horoscapp.databinding.ActivityMainBinding
import com.alexanderdev.horoscapp.databinding.FragmentHoroscopoBinding
import com.alexanderdev.horoscapp.domain.model.HoroscopoModel
import com.alexanderdev.horoscapp.domain.model.HoroscopoModel.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopoDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHoroscopoDetailBinding
    private val horoscopoDetailViewModel:HoroscopoDetailViewModel by viewModels()

    private val args:HoroscopoDetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopoDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        horoscopoDetailViewModel.getHoroscopo(args.type)
    }

    private fun initUI(){
        initListeners()
        initUIState()
    }

    private fun initListeners(){
        binding.ivBack.setOnClickListener{onBackPressed()}
    }

    private fun initUIState(){
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                horoscopoDetailViewModel.state.collect{
                    when(it){
                        HoroscopoDetailState.Loading -> loadingState()
                        is HoroscopoDetailState.Error -> errorState()
                        is HoroscopoDetailState.Success -> successState(it)
                    }

                }

            }
        }

    }

    private fun loadingState(){
         binding.pb.isVisible = true
    }

    private fun errorState(){
        binding.pb.isVisible = false

    }

    private fun successState(state: HoroscopoDetailState.Success){
        binding.pb.isVisible = false
        binding.tvTitle.text = state.sign
        binding.tvBody.text = state.prediction

       val image :Int = when(state.horoscopoModel){
            Aries -> R.drawable.detail_aries
            Taurus -> R.drawable.detail_taurus
            Gemini -> R.drawable.detail_gemini
            Cancer -> R.drawable.detail_cancer
            Leo -> R.drawable.detail_leo
            Virgo -> R.drawable.detail_virgo
            Libra -> R.drawable.detail_libra
            Scorpio -> R.drawable.detail_scorpio
            Sagittarius -> R.drawable.detail_sagittarius
            Capricorn -> R.drawable.detail_capricorn
            Aquarius -> R.drawable.detail_aquarius
            pisces -> R.drawable.detail_pisces
        }

        binding.ivDetail.setImageResource(image)
    }
}
