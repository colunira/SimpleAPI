package com.example.firstapi.model

import com.google.gson.annotations.SerializedName

class MeasuringStation {
    @SerializedName("id") val id: Int = 0
    @SerializedName("stationName") val name: String = ""

    override fun toString(): String {
        return "$id. $name"
    }
}