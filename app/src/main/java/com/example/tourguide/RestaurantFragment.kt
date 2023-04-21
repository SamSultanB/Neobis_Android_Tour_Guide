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
import com.example.tourguide.databinding.FragmentRestaurantBinding

class RestaurantFragment : Fragment(), RecyclerViewAdapter.Listener {

    lateinit var restaurantBinding: FragmentRestaurantBinding

    lateinit var restaurants: ArrayList<Place>

    var imperia = Place(R.drawable.restaurant3, "Imperia Pizza", "Aхунбаева 173",
        "open till 23:00", "1.5 km", "средний чек 800 сом", "Welcome to imperia pizza!")
    var restaurant = Place(R.drawable.restaurant4, "Restaurant", "VEFA",
        "open till 22:00", "1.0 km", "средний чек 1000 сом", "Welcome to our restaurant!")

    var dodoPizza = Place(R.drawable.restaurant2, "Dodo Pizza", "Maksim Gorkiy 20",
        "open till 21:00", "0.2 km", "average check 600 soms", "Welcome to Dodo Pizza!")

    var navat = Place(R.drawable.restaurant3, "Navat", "Baitik Baatyr 211",
        "open till 00:00", "0.3 km", "average check 500 soms", "Welcome to Navat!")

    var classic = Place(R.drawable.restaurant1, "Classic", "Bishkek Park",
        "open till 00:00", "2.5 km", "average check 1500 soms", "Welcome to Classic")
    var novotel = Place(R.drawable.restaurant4, "Novotel", "Chyngyz Aitmatov 21",
        "open 24/7", "3.0 km", "average check 1700 soms", "Welcome to Novotel")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        restaurantBinding = FragmentRestaurantBinding.inflate(layoutInflater, container, false)

        restaurantBinding.recyclerViewRestaurant.layoutManager = LinearLayoutManager(this.context)

        restaurants = arrayListOf(imperia, restaurant, dodoPizza, navat, classic, novotel)
        restaurantBinding.recyclerViewRestaurant.adapter = RecyclerViewAdapter(restaurants, this)

        return restaurantBinding.root
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