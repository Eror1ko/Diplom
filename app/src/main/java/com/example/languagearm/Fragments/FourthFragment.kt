package com.example.languagearm.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.languagearm.ConnectSupaBase
import com.example.languagearm.CustomAdapter
import com.example.languagearm.DataTime
import com.example.languagearm.HistoryAdapter
import com.example.languagearm.R
import kotlinx.coroutines.launch


class FourthFragment : Fragment() {

    lateinit var hsadapter : HistoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_fourth, container, false)
        hsadapter = HistoryAdapter(DataTime.historyData)
        var mRecyclerAdr = view.findViewById<RecyclerView>(R.id.recyclerhistory);
        mRecyclerAdr.adapter = hsadapter
        lifecycleScope.launch {
            ConnectSupaBase().HistoryRecycler()
            hsadapter.notifyDataSetChanged()
        }



        return view
    }
}