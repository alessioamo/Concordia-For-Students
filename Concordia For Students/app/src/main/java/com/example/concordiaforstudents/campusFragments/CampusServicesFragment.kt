package com.example.concordiaforstudents.campusFragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.concordiaforstudents.R

class CampusServicesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("CampusServicesFragment", "onCreateView called")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_campusservices, container, false)
    }
}