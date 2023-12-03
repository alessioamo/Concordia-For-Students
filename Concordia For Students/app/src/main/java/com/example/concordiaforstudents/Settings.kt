package com.example.concordiaforstudents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Switch
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.concordiaforstudents.R

class Settings : Fragment() {

    private lateinit var darkModeSwitch: Switch
    private lateinit var languageSpinner: Spinner
    private lateinit var logoutButton: TextView
    private lateinit var settingsContainer: ViewGroup // The container of the entire settings layout
    private lateinit var settingsTitle: TextView
    private lateinit var imageView: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_settings, container, false)
        settingsContainer = view.findViewById(R.id.settingsContainer)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize views
        darkModeSwitch = view.findViewById(R.id.darkModeSwitch)
        languageSpinner = view.findViewById(R.id.languageSpinner)
        logoutButton = view.findViewById(R.id.logoutButton)
        settingsTitle = view.findViewById(R.id.textView)
        imageView = view.findViewById(R.id.arrowLogout)

        darkModeSwitch.setOnCheckedChangeListener { _, isChecked ->
            // Handle dark mode switch changes here
            if (isChecked) {
                // Enable dark mode
                enableDarkMode()
            } else {
                // Disable dark mode
                disableDarkMode()
            }
        }

        // Populate the language spinner
        val languages = arrayOf("English", "French")
        val adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, languages)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        languageSpinner.adapter = adapter

        // Set click listener for logout button
        logoutButton.setOnClickListener {
            // Handle logout button click here
        }
    }

    private fun enableDarkMode() {
        // Change background to gray when dark mode is enabled
        settingsContainer.setBackgroundColor(resources.getColor(android.R.color.system_background_dark))

        // Set text color to white for relevant TextViews
        logoutButton.setTextColor(resources.getColor(R.color.darkmodetext))
        darkModeSwitch.setTextColor(resources.getColor(R.color.darkmodetext))
        // settingsTitle.setBackgroundColor(resources.getColor(R.color.darkmodetext))

        // Set tint for the ImageView
        imageView.setColorFilter(resources.getColor(R.color.darkmodetext))


        // Set text color for the spinner items
        val languages = arrayOf("English", "French")
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            languages
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        languageSpinner.adapter = object : ArrayAdapter<String>(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            languages
        ) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getView(position, convertView, parent)
                (view as? TextView)?.setTextColor(resources.getColor(R.color.darkmodetext))
                return view
            }

            override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getDropDownView(position, convertView, parent)
                (view as? TextView)?.setTextColor(resources.getColor(R.color.darkmodetext))
                return view
            }
        }
    }


    private fun disableDarkMode() {
        // Change background back to normal when dark mode is disabled
        settingsContainer.setBackgroundColor(resources.getColor(android.R.color.white))

        // Set text color back to normal for relevant TextViews
        logoutButton.setTextColor(resources.getColor(R.color.burgundy))
        darkModeSwitch.setTextColor(resources.getColor(R.color.burgundy))
        settingsTitle.setBackgroundColor(resources.getColor(R.color.burgundy))

        // Set tint for the ImageView
        imageView.setColorFilter(resources.getColor(R.color.burgundy))

        // Set text color for the spinner items
        val languages = arrayOf("English", "French")
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            languages
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        languageSpinner.adapter = object : ArrayAdapter<String>(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            languages
        ) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getView(position, convertView, parent)
                (view as? TextView)?.setTextColor(resources.getColor(R.color.burgundy))
                return view
            }

            override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getDropDownView(position, convertView, parent)
                (view as? TextView)?.setTextColor(resources.getColor(R.color.burgundy))
                return view
            }
        }
    }

}
