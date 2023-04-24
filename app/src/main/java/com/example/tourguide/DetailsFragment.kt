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
import com.bumptech.glide.Glide
import com.example.tourguide.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    lateinit var detailBinding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        detailBinding = FragmentDetailsBinding.inflate(inflater, container, false)
        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val place = arguments?.getParcelable<Place>("place")
        Glide.with(detailBinding.image)
            .load(place?.placeImage)
            .into(detailBinding.image)
        detailBinding.apply {
            detailName.text = place?.name
            detailAddress.text = place?.address
            detailTimeTable.text = place?.timeTable
            detailDistance.text = place?.distance
            detailPrice.text = place?.price
            detailDesciption.text = place?.description
            detailName2.text = place?.name
            detailContact.text = place?.contact
        }

        //navigate back
        detailBinding.goBackButton.setOnClickListener {
            findNavController().navigate(R.id.navigateToHostFragment)
        }
        //opens map
        detailBinding.detailAddress.setOnClickListener {
            try {
                var map = Intent(Intent.ACTION_VIEW, Uri.parse("geo: ${place?.locationMap}"))
                startActivity(Intent.createChooser(map, "Choose map"))
            }catch (e: ActivityNotFoundException){
                Toast.makeText(activity, "Can't open it", Toast.LENGTH_SHORT)
            }
        }

        //call action
        detailBinding.detailContact.setOnClickListener {
            try {
                var call = Intent(Intent.ACTION_DIAL, Uri.parse("tel: ${place?.contact}"))
                startActivity(Intent.createChooser(call, "Choose app"))
            }catch (e: ActivityNotFoundException){
                Toast.makeText(activity, "Something went wrong!", Toast.LENGTH_SHORT)
            }
        }


    }

}