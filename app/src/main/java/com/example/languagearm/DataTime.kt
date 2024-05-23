package com.example.languagearm

import android.annotation.SuppressLint
import com.example.languagearm.Fragments.SecondFragment
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DataTime {
    companion object {
        var infoData: ArrayList<DataClass.City> = ArrayList();
        var historyData: ArrayList<DataClass.Hs> = ArrayList();
        var user = DataClass.User()
        var dictionary: ArrayList<DataClass.Diction> = ArrayList();
        var situations: ArrayList<DataClass.Situations> = ArrayList();
        var sortDictionary: ArrayList<DataClass.Diction> = ArrayList();
        var selectSituation = 2
    }

    @SuppressLint("NotifyDataSetChanged")
    fun sortDict1() {
        sortDictionary.clear();
        for (i in 0 until dictionary.size) {
            if (dictionary[i].id_situation == selectSituation) {
                sortDictionary.add(dictionary[i])


                SecondFragment.dictionAd.notifyDataSetChanged()
            }
        }

    }
}