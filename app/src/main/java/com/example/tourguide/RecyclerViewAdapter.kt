package com.example.tourguide

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
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
        var isExpandable: Boolean = places[position].expandable
        holder.binding.additionsHolder.visibility = if(isExpandable) View.VISIBLE else View.GONE
        holder.binding.holder.setOnClickListener {
            places[position].expandable = !places[position].expandable
            notifyItemChanged(position)
        }
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
            textPrice.text = place.price
            textDescription.text = place.description
            textContact.text = place.contact
        }

    }

    interface Listener{
        fun onClick(place: Place)
    }

}