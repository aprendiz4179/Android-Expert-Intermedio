package com.alexanderdev.horoscapp.ui.home.horoscopo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexanderdev.horoscapp.R
import com.alexanderdev.horoscapp.databinding.FragmentHoroscopoBinding
import com.alexanderdev.horoscapp.domain.model.HoroscopoInfo
import com.alexanderdev.horoscapp.domain.model.HoroscopoInfo.*
import com.alexanderdev.horoscapp.domain.model.HoroscopoModel
import com.alexanderdev.horoscapp.ui.home.horoscopo.adapter.HoroscopoAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopoFragment : Fragment() {

    private val horoscopoViewModel by viewModels<HoroscopoViewModel> ()
    private lateinit var horoscopoAdapter: HoroscopoAdapter
    private var _binding: FragmentHoroscopoBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI(){
        initList()
        initUIState()

    }

    private fun initList(){
        horoscopoAdapter = HoroscopoAdapter(onItemSelected = {
            val type :HoroscopoModel = when(it){
                Acuario -> HoroscopoModel.Aquarius
                Aries -> HoroscopoModel.Aries
                Cancer -> HoroscopoModel.Cancer
                Capricornio -> HoroscopoModel.Capricorn
                Escorpion -> HoroscopoModel.Scorpio
                Geminis -> HoroscopoModel.Gemini
                Leo -> HoroscopoModel.Leo
                Libra -> HoroscopoModel.Libra
                Piscis -> HoroscopoModel.pisces
                Sagitario -> HoroscopoModel.Sagittarius
                Tauro -> HoroscopoModel.Taurus
                Virgo -> HoroscopoModel.Virgo
            }

            findNavController().navigate(
                HoroscopoFragmentDirections.actionHoroscopoFragmentToHoroscopoDetailActivity(type)

            )
           // Toast.makeText(context,getString(it.name ),Toast.LENGTH_LONG).show()
        })

        binding.rvHoroscopo.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = horoscopoAdapter
        }

      //  binding.rvHoroscopo.layoutManager = GridLayoutManager(context)
      //  binding.rvHoroscopo.adapter = horoscopoAdapter
    }

    private fun initUIState(){
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                horoscopoViewModel.horoscopo.collect(){
                    //CAMBIOS EN HOROSCOPO
                    horoscopoAdapter.updateList(it)

                }
            }

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHoroscopoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}