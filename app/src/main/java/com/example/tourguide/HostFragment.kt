package com.example.tourguide

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tourguide.databinding.ActivityMainBinding
import com.example.tourguide.databinding.FragmentHostBinding
import com.google.android.material.tabs.TabLayoutMediator

class HostFragment : Fragment() {

    lateinit var hostFragmentBinding: FragmentHostBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        hostFragmentBinding = FragmentHostBinding.inflate(inflater, container, false)

        val tabLayout = hostFragmentBinding.tabLayout
        val viewPager = hostFragmentBinding.fragmentHolder

        viewPager.adapter = ViewPagerAdapter(parentFragmentManager, lifecycle)

        TabLayoutMediator(tabLayout, viewPager){tab, position ->
            when(position){
                0 -> tab.text = "Restaurants"
                1 -> tab.text = "Gym centers"
                2 -> tab.text = "Cinemas"
            }
        }.attach()

        return hostFragmentBinding.root
    }

}