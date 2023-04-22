package com.example.tourguide

class Place(val placeImage: Int,
            val name: String,
            val address: String,
            val timeTable: String,
            val distance: String,
            val price: String,
            val description: String,
            val contact: String,
            var expandable: Boolean = false)