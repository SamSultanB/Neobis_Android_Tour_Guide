package com.example.tourguide

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tourguide.databinding.FragmentCinemaBinding
import com.example.tourguide.databinding.FragmentRestaurantBinding

class RestaurantFragment : Fragment() {

    lateinit var restaurantBinding: FragmentRestaurantBinding

    lateinit var restaurants: ArrayList<Place>

    var imperia = Place(R.drawable.restaurant2, "Imperia Pizza", "Aхунбаева 173",
        "open till 23:00", "1.5 km", "средний чек 800 сом", "Welcome to imperia pizza!")
    var restaurant = Place(R.drawable.restaurant1, "Restaurant", "VEFA",
        "open till 22:00", "1.0 km", "средний чек 1000 сом", "Welcome to our restaurant!")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        restaurantBinding = FragmentRestaurantBinding.inflate(layoutInflater, container, false)

        restaurantBinding.recyclerViewRestaurant.layoutManager = LinearLayoutManager(this.context)

        restaurants = arrayListOf(imperia, restaurant)
        restaurantBinding.recyclerViewRestaurant.adapter = RecyclerViewAdapter(restaurants)

        return restaurantBinding.root
    }

}