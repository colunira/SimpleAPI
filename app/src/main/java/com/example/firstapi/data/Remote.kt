package com.example.firstapi.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.firstapi.model.MeasuringStation
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Remote {
    val retrofit = Retrofit.Builder().baseUrl("http://api.gios.gov.pl/pjp-api/rest/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create())).build()
    val airService = retrofit.create(AirAPI::class.java)

    fun getStations(): MutableLiveData<List<MeasuringStation>> {
        val stationsList = MutableLiveData<List<MeasuringStation>>()
        val call = airService.loadStations()
        call.enqueue(object : Callback<List<MeasuringStation>> {
            override fun onFailure(call: Call<List<MeasuringStation>>, t: Throwable) {
                Log.v("firstAPI ERROR", t.toString())
            }
            override fun onResponse(
                call: Call<List<MeasuringStation>>,
                response: Response<List<MeasuringStation>>
            ) {
                stationsList.value = response.body()
            }
        })

        return stationsList
    }
}