package com.example.weatherapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.R
import com.example.weatherapp.adapter.WeatherAdapter
import com.example.weatherapp.api.RetrofitClient
import com.example.weatherapp.databinding.FragmentMainBinding
import com.example.weatherapp.model.WeatherResponse
import kotlinx.coroutines.launch


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val weatherList = mutableListOf<WeatherResponse>()
    private lateinit var adapter: WeatherAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize RecyclerView
        adapter = WeatherAdapter(weatherList) { selectedWeather ->
            // Navigate to DetailFragment with Safe Args
            val action =
                MainFragmentDirections.actionMainFragmentToDetailFragment(selectedWeather)
            findNavController().navigate(action)
        }
        binding.weatherRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.weatherRecyclerView.adapter = adapter

        // Fetch weather data
        binding.searchButton.setOnClickListener {
            val cityName = binding.cityInput.text.toString()
            if (cityName.isNotEmpty()) {
                fetchWeather(cityName)
            }
        }
    }

    private fun fetchWeather(city: String) {
        lifecycleScope.launch {
            try {
                val response = RetrofitClient.instance.getWeather(city, "87655c9e85dfdc79596e239bf82090a3")
                weatherList.clear()
                weatherList.add(response)
                adapter.notifyDataSetChanged()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}