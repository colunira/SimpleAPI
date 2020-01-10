package com.example.firstapi.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapi.R
import com.example.myapplication.StationsListAdapter
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.loadStations().observe(this, Observer { data ->
            if (data != null) {
                stationsListView.layoutManager =
                    LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
                stationsListView.adapter = StationsListAdapter(data)
                Log.v("Glowne",data.toString())
            }
            else {
                Log.v("NIE","DZIALA")
            }
        })
    }
}
