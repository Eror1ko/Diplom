package com.example.languagearm

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DictionaryAdapter (private var data: ArrayList<DataClass.Diction>): RecyclerView.Adapter<DictionaryAdapter.ViewHolder>() {


    class ViewHolder(itemView: View, private val listener: View.OnClickListener) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val textTtt : TextView = itemView.findViewById(R.id.textTxt);
        val proiz : TextView = itemView.findViewById(R.id.proizTxt)
        val trans : TextView = itemView.findViewById(R.id.transTxt)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            listener.onClick(v);
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tag = data[position];
        holder.textTtt.text = data[position].слово
        holder.proiz.text = data[position].произношение
        holder.trans.text = data[position].перевод
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.dictionaryrecycler, parent, false)

        return ViewHolder(view, View.OnClickListener {})
    }

    override fun getItemCount(): Int {
        return data.size
    }
}