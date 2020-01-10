package com.example.firstapi.data

import androidx.lifecycle.MutableLiveData
import com.example.firstapi.model.MeasuringStation

class Repository {
    companion object {
        private var instance: Repository? = null

        fun getInstance(): Repository {
            if(instance==null)
                instance = Repository()
            return instance as Repository
        }
    }

    val remote = Remote()

    fun getStations(): MutableLiveData<List<MeasuringStation>> {
        //TODO: return form local store if needed
        return remote.getStations()
    }
}