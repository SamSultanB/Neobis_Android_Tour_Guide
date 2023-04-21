package com.example.tourguide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat.Action
import com.example.tourguide.databinding.ActivityDetailsActivictyBinding

class DetailsActivicty : AppCompatActivity() {
    lateinit var binding: ActivityDetailsActivictyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsActivictyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.placeImage.setImageResource(intent.getIntExtra("image", 0))
        binding.textName.setText(intent.getStringExtra("name"))
        binding.textAddress.setText(intent.getStringExtra("address"))
        binding.textTimeTable.setText(intent.getStringExtra("time table"))
        binding.textDistance.setText(intent.getStringExtra("distance"))
        binding.textDescription.setText(intent.getStringExtra("description"))

    }
}