package com.example.languagearm.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.languagearm.ConnectSupaBase
import com.example.languagearm.CustomAdapter
import com.example.languagearm.DataTime
import com.example.languagearm.R
import kotlinx.coroutines.launch


class FirstFragment : Fragment() {

    lateinit var customAdapter : CustomAdapter
//    var customAdapter = CustomAdapter(DataTime.infoData)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_first, container, false)
        // Inflate the layout for this fragment
    customAdapter = CustomAdapter(DataTime.infoData)
    var mRecyclerAdr = view.findViewById<RecyclerView>(R.id.recycleridcity);
    mRecyclerAdr.adapter = customAdapter
        lifecycleScope.launch {
            ConnectSupaBase().CityRecycler()
            customAdapter.notifyDataSetChanged()
        }
    var name  = view.findViewById<TextView>(R.id.nameTxt)

    name.text = DataTime.user.имя

        return view





    }

}