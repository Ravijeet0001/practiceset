package com.example.weatherapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs

import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val weather = args.weather
        binding.cityName.text = weather.name
        binding.temperature.text = "${weather.main.temp}°C"
        binding.humidity.text = "Humidity: ${weather.main.humidity}%"
        //binding.windSpeed.text = "Wind Speed: ${weather.wind.speed} m/s"
        binding.description.text = weather.weather.firstOrNull()?.description ?: "N/A"
    }
}