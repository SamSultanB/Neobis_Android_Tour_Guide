package com.example.tourguide

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tourguide.databinding.FragmentGymBinding
import com.example.tourguide.databinding.FragmentRestaurantBinding


class GymFragment : Fragment(), RecyclerViewAdapter.Listener {

    lateinit var gymBinding: FragmentGymBinding

    lateinit var gyms: ArrayList<Place>

    var delta = Place(R.drawable.gym1, "Delta", "Akhmatbek Suyunbaev 140",
        "open till 00:00", "2.5 km", "500 soms", "Welcome to Delta gym!","+996553125486")
    var sixPound = Place(R.drawable.gym2, "Limon", "Lev Tolstoy 34a",
        "open till 23:00", "3.0 km", "400 soms", "Welcome to our Limon gym!", "+996553125486")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        gymBinding = FragmentGymBinding.inflate(layoutInflater, container, false)

        gymBinding.recyclerViewGym.layoutManager = LinearLayoutManager(this.context)

        gyms = arrayListOf(delta, sixPound)
        gymBinding.recyclerViewGym.adapter = RecyclerViewAdapter(gyms, this)

        return gymBinding.root
    }

    override fun onClick(place: Place) {
//        var intent = Intent(activity, DetailsActivicty::class.java)
//        intent.putExtra("image", place.placeImage)
//        intent.putExtra("name", place.name)
//        intent.putExtra("address", place.address)
//        intent.putExtra("time table", place.timeTable)
//        intent.putExtra("distance", place.distance)
//        intent.putExtra("description", place.description)
//        startActivity(intent)
    }


}