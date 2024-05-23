package com.example.languagearm

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import org.w3c.dom.Text

class HistoryAdapter (private var data: ArrayList<DataClass.Hs>): RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {


    class ViewHolder(itemView: View, private val listener: View.OnClickListener) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val name: TextView = itemView.findViewById(R.id.textRec);
        val descrip : TextView = itemView.findViewById(R.id.textRec1)
        var image : ImageView = itemView.findViewById(R.id.imageRec)


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
//        holder.itemView.setOnClickListener {
//            val layout = LayoutInflater.from(holder.itemView.context);
//
//            val bottomSheetDialog = BottomSheetDialog(holder.itemView.context)
//
//
//            val view = layout.inflate(R.layout.activity_bottomsheet, null)
//            bottomSheetDialog.setContentView(view)
//            bottomSheetDialog.show()
//
//            val btnClose = view.findViewById<Button>(R.id.btnClose)
//            btnClose.setOnClickListener {
//                bottomSheetDialog.dismiss();
//            }
//
//            val image = view.findViewById<ImageView>(R.id.imageSheet);
//            image.setImageDrawable(data[position].фото)
//
//            val desc = view.findViewById<TextView>(R.id.descCity);
//            desc.text = data[position].описание;
//
//            val title = view.findViewById<TextView>(R.id.nameCity);
//            title.text = data[position].название
//
//            // Отображение BottomSheet
//            bottomSheetDialog.show()
//        }
        holder.name.text = data[position].название;
        holder.descrip.text = data[position].описание
        holder.image.setImageDrawable(data[position].фото)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.historyrecycler, parent, false)

        return ViewHolder(view, View.OnClickListener {})
    }

    override fun getItemCount(): Int {
        return data.size
    }
}