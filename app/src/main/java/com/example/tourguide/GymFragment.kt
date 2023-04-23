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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tourguide.databinding.FragmentGymBinding
import com.example.tourguide.databinding.FragmentRestaurantBinding


class GymFragment : Fragment(), RecyclerViewAdapter.Listener {

    lateinit var gymBinding: FragmentGymBinding

    lateinit var gyms: ArrayList<Place>

    var delta = Place(R.drawable.gym1, "Delta", "Akhmatbek Suyunbaev 140",
        "open till 00:00", "2.5 km", "500 soms", "Welcome to Delta gym! The best gym in the world. We have all kind of equipments!","+996553125486", "70000001035410799")
    var sixPound = Place(R.drawable.gym2, "Limon", "Lev Tolstoy 34a",
        "open till 23:00", "3.0 km", "400 soms", "Welcome to our Limon gym! The best gym but we don't have all kind of equipments, use your imagination to train with equipment that you have!", "+996553125486", "70000001035410799")

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
        val fragment = DetailsFragment()
        fragment.arguments = bundle
        parentFragmentManager.beginTransaction()
            .replace(R.id.hostFragment, fragment).commit()
    }


}