package com.example.asonbom.data.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.asonbom.R
import com.example.asonbom.data.responses.InfoStations
import kotlinx.android.synthetic.main.row_layout.view.*

class AdapterLayout (private val personList: ArrayList<InfoStations>, private val listener: LoginActivity): RecyclerView.Adapter<AdapterLayout.ViewHolder>() {
    interface Listener {
        fun onItemClick(infoStations: InfoStations)
    }

    private val colors: Array<String> =  arrayOf("#6BF2E5", "#4ED98A", "#F2B705", "#F25C05", "#F23A29")

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(personList[position], listener, colors, position)
    }

    override fun getItemCount(): Int = personList.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        fun bind(infoStations: InfoStations,listener: Listener,colors: Array<String>,position: Int){
            itemView.setOnClickListener{ listener.onItemClick(infoStations)}
            itemView.setBackgroundColor(Color.parseColor(colors[position%5]))
            itemView.text_name.text = infoStations.response.toString()
            itemView.text_info.text = infoStations.status
        }

    }
}