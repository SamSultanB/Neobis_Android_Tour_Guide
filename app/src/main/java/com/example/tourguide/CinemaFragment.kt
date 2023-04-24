package com.example.tourguide

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tourguide.databinding.FragmentCinemaBinding

class CinemaFragment : Fragment(), RecyclerViewAdapter.Listener{

    lateinit var cinemaBinding: FragmentCinemaBinding

    lateinit var cinemas: ArrayList<Place>

    var manas = Place(R.drawable.cinema1, "Manas", "Московская 24", "open 24/7",
        "1.5 km", "300 сом", "Welcome to Manas cinema! The national cinema in Bishkek", "+996553125486", "70000001019352753")
    var alatoo = Place(R.drawable.cinema2, "Ala-Too", "Молодая Гвардия 124", "open till 24:00",
        "1.0 km", "250 som", "Welcome to Ala-Too cinema! Just Ala-Too cinema just cinema", "+996553125486", "70000001019352753")

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

    override fun callAction(number: String) {
        try {
            var call = Intent(Intent.ACTION_DIAL, Uri.parse("tel: $number"))
            startActivity(Intent.createChooser(call, "Choose app"))
        }catch (e: ActivityNotFoundException){
            Toast.makeText(activity, "Something went wrong!", Toast.LENGTH_SHORT)
        }
    }

    override fun openMap(location: String) {
        try {
            var map = Intent(Intent.ACTION_VIEW, Uri.parse("geo: $location"))
            startActivity(Intent.createChooser(map, "Choose map"))
        }catch (e: ActivityNotFoundException){
            Toast.makeText(activity, "Can't open it", Toast.LENGTH_SHORT)
        }
    }

    override fun itemClick(place: Place) {
        val bundle = Bundle()
        bundle.putParcelable("place", place)
        findNavController().navigate(R.id.navigateToDetailsFragment, bundle)
    }

}