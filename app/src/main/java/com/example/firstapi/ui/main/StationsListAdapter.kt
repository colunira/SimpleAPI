package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapi.R
import com.example.firstapi.model.MeasuringStation

class StationsListAdapter(val stations: List<MeasuringStation>) : RecyclerView.Adapter<StationsListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.measuring_station, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val station = stations[position]
        holder.stationIDView.text=station.id.toString()
        holder.stationNameView.text=station.name
    }

    override fun getItemCount(): Int {
        return stations.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val stationIDView = itemView.findViewById<TextView>(R.id.idTextView)
        val stationNameView = itemView.findViewById<TextView>(R.id.nameTextView)
    }
}