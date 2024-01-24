package com.alexanderdev.horoscapp.ui.home.horoscopo.adapter

import android.content.Context
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.alexanderdev.horoscapp.databinding.ItemHoroscopoBinding
import com.alexanderdev.horoscapp.domain.model.HoroscopoInfo

class HoroscopoViewHolder(view: View):RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopoBinding.bind(view)

    fun render(horoscopoInfo: HoroscopoInfo, onItemselected: (HoroscopoInfo)-> Unit){
        val context :Context = binding.tvTitle.context
        binding.ivHoroscopo.setImageResource(horoscopoInfo.img)
        binding.tvTitle.text = context.getString(horoscopoInfo.name)

        binding.parent.setOnClickListener{
            startRotationAnimation(binding.ivHoroscopo, newLambda = {onItemselected(horoscopoInfo)})
          //  onItemselected(horoscopoInfo)

        }

    }

    private fun startRotationAnimation(view: View, newLambda: ()->Unit){
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction { newLambda() }
            start()
        }

    }
}