package com.example.tourguide

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
            detailDistance.text = place?.distance
            detailPrice.text = place?.price
            detailDesciption.text = place?.description
            detailName2.text = place?.name
            detailContact.text = place?.contact
        }
        detailBinding.goBackButton.setOnClickListener {
            findNavController().navigate(R.id.navigateToHostFragment)
        }

    }

}