package com.example.tourguide

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Place(val placeImage: Int,
            val name: String,
            val address: String,
            val timeTable: String,
            val distance: String,
            val price: String,
            val description: String,
            val contact: String,
            val locationMap: String) : Parcelable