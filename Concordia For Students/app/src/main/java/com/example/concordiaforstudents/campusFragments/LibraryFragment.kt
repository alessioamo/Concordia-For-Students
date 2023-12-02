package com.example.concordiaforstudents.campusFragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.concordiaforstudents.R
import java.util.Calendar
import java.util.Random

class LibraryFragment : Fragment() {

    private lateinit var randomNumberTextView1: TextView
    private lateinit var randomNumberTextView2: TextView
    private lateinit var randomNumberTextView3: TextView
    private lateinit var lastUpdatedText: TextView
    private lateinit var randomizeButton: Button
    private val random = Random()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("LibraryFragment", "onCreateView called")
        val view = inflater.inflate(R.layout.fragment_library, container, false)

        randomNumberTextView1 = view.findViewById(R.id.randomNumberTextView1)
        randomNumberTextView2 = view.findViewById(R.id.randomNumberTextView2)
        randomNumberTextView3 = view.findViewById(R.id.randomNumberTextView3)
        lastUpdatedText = view.findViewById(R.id.lastUpdatedText)
        randomizeButton = view.findViewById(R.id.randomizeButton)

        randomNumberTextView1.setOnClickListener {
            showPopup("Webster", randomNumberTextView1.text.toString().substringAfter("\n"))
        }

        randomNumberTextView2.setOnClickListener {
            showPopup("Vanier", randomNumberTextView2.text.toString().substringAfter("\n"))
        }

        randomNumberTextView3.setOnClickListener {
            showPopup("Grey Nuns", randomNumberTextView3.text.toString().substringAfter("\n"))
        }

        randomizeButton.setOnClickListener {
            updateRandomNumber()
        }

        return view
    }

    private fun showPopup(libraryName: String, occupancy: String) {
        val popupFragment = LibraryPopupFragment(libraryName, occupancy)
        popupFragment.show(childFragmentManager, "LibraryPopupFragment")
    }

    private fun updateRandomNumber() {
        val randomNumber1 = generateRandomNumber1()
        val randomNumber2 = generateRandomNumber2()
        val randomNumber3 = generateRandomNumber3()
        randomNumberTextView1.text = "Webster\n$randomNumber1"
        randomNumberTextView2.text = "Vanier\n$randomNumber2"
        randomNumberTextView3.text = "Grey Nuns\n$randomNumber3"

        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        val formattedTime = String.format("%02d:%02d", hour, minute)
        lastUpdatedText.text = "Last updated: $formattedTime"
    }

    private fun generateRandomNumber1(): Int {
        return (random.nextInt(1000 - 900 + 1) + 900)
    }

    private fun generateRandomNumber2(): Int {
        return (random.nextInt(680 - 600 + 1) + 600)
    }

    private fun generateRandomNumber3(): Int {
        return (random.nextInt(200 - 150 + 1) + 150)
    }
}