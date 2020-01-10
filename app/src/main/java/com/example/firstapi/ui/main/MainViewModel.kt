package com.example.firstapi.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firstapi.data.Repository
import com.example.firstapi.model.MeasuringStation

class MainViewModel : ViewModel() {
    val repository = Repository.getInstance()

    fun loadStations(): LiveData<List<MeasuringStation>> {
        return repository.getStations()
    }
}