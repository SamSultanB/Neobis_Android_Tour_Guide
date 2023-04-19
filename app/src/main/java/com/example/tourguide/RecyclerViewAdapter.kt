package com.example.tourguide

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(val places: ArrayList<Place>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = places[position]
        holder.placeImage.setImageResource(item.placeImage)
        holder.placeName.text = item.name
        holder.placeAddress.text = item.address
        holder.timeTable.text = item.timeTable
        holder.distance.text = item.distance


    }

    override fun getItemCount(): Int {
        return places.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val placeImage: ImageView = itemView.findViewById(R.id.place_image)
        val placeName: TextView = itemView.findViewById(R.id.text_name)
        val placeAddress: TextView = itemView.findViewById(R.id.text_address)
        val timeTable: TextView = itemView.findViewById(R.id.text_timeTable)
        val distance: TextView = itemView.findViewById(R.id.text_distance)

    }

}