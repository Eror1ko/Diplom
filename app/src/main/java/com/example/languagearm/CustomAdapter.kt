package com.example.languagearm

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class CustomAdapter (private var data: ArrayList<DataClass.City>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    class ViewHolder(itemView: View, private val listener: View.OnClickListener) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val name: TextView = itemView.findViewById(R.id.textadapter);
      val descrip : TextView = itemView.findViewById(R.id.textdesctip)


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
        holder.name.text = data[position].название;
      holder.descrip.text = data[position].описание
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.customcityrecycler, parent, false)

        return ViewHolder(view, View.OnClickListener {})
    }

    override fun getItemCount(): Int {
        return data.size
    }
}