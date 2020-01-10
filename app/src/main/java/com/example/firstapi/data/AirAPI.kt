package com.example.firstapi.data

import com.example.firstapi.model.MeasuringStation
import com.example.firstapi.model.MeasurmentDevice
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface AirAPI {
    @GET("station/findAll")
    fun loadStations(): Call<List<MeasuringStation>>
}