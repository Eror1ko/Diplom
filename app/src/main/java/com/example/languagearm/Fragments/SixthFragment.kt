package com.example.languagearm.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import com.example.languagearm.DataTime
import com.example.languagearm.R



class SixthFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         val view = inflater.inflate(R.layout.fragment_sixth, container, false)
        var nameEdit = view.findViewById<EditText>(R.id.editName)
        var mailTxt = view.findViewById<TextView>(R.id.mailTxt)

        nameEdit.setText(DataTime.user.имя)
        mailTxt.text = DataTime.user.email

        return view




    }
}