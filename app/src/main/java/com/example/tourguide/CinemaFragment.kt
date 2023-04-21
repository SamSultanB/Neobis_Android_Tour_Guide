package com.example.tourguide

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tourguide.databinding.FragmentCinemaBinding

class CinemaFragment : Fragment(), RecyclerViewAdapter.Listener{

    lateinit var cinemaBinding: FragmentCinemaBinding

    lateinit var cinemas: ArrayList<Place>

    var manas = Place(R.drawable.cinema1, "Manas", "Московская 24",
        "open 24/7", "1.5 km", "300 сом", "Welcome to Manas cinema!")
    var alatoo = Place(R.drawable.cinema2, "Ala-Too", "Молодая Гвардия 124",
        "open till 24:00", "1.0 km", "250 som", "Welcome to Ala-Too cinema")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        cinemaBinding = FragmentCinemaBinding.inflate(layoutInflater, container, false)

        cinemaBinding.recyclerViewCinema.layoutManager = LinearLayoutManager(this.context)

        cinemas = arrayListOf(manas, alatoo)
        cinemaBinding.recyclerViewCinema.adapter = RecyclerViewAdapter(cinemas, this)

        return cinemaBinding.root
    }

    override fun onClick(place: Place) {
        var intent = Intent(activity, DetailsActivicty::class.java)
        intent.putExtra("image", place.placeImage)
        intent.putExtra("name", place.name)
        intent.putExtra("address", place.address)
        intent.putExtra("time table", place.timeTable)
        intent.putExtra("distance", place.distance)
        intent.putExtra("description", place.description)
        startActivity(intent)
    }

}