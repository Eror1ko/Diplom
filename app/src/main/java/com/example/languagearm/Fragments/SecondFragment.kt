package com.example.languagearm.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.languagearm.ConnectSupaBase
import com.example.languagearm.DataTime
import com.example.languagearm.DictionaryAdapter
import com.example.languagearm.HistoryAdapter
import com.example.languagearm.R
import com.example.languagearm.SituationsAdapter
import kotlinx.coroutines.launch


class SecondFragment : Fragment() {

    companion object{
        lateinit var sitadapter : SituationsAdapter
        var dictionAd  = DictionaryAdapter(DataTime.sortDictionary)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_second, container, false)
        sitadapter = SituationsAdapter(DataTime.situations)
        var mRecyclerAdr = view.findViewById<RecyclerView>(R.id.sitRecycler);


        dictionAd = DictionaryAdapter(DataTime.sortDictionary)
        var dicRec = view.findViewById<RecyclerView>(R.id.dictionRecycler);
        dicRec.adapter = dictionAd


        mRecyclerAdr.adapter = sitadapter
        lifecycleScope.launch {
            ConnectSupaBase().SituationsRecycler()
            sitadapter.notifyDataSetChanged()


            ConnectSupaBase().DictionaryRecycler()
            DataTime().sortDict1()
        }


        return view
    }

}