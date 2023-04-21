package com.example.tourguide

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tourguide.databinding.ListItemBinding

class RecyclerViewAdapter(val places: ArrayList<Place>, val listener: Listener) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = places[position]
        holder.bind(item, listener)

    }

    override fun getItemCount(): Int {
        return places.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val binding = ListItemBinding.bind(itemView)
        fun bind(place: Place, listener: Listener) = with(binding){
            Glide.with(binding.placeImage).load(place.placeImage).into(binding.placeImage)
            textName.text = place.name
            textAddress.text = place.address
            textTimeTable.text = place.timeTable
            textDistance.text = place.distance
            textName.setOnClickListener {
                listener.onClick(place)
            }

        }

    }

    interface Listener{
        fun onClick(place: Place)
    }

}