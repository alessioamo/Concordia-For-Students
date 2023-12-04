package com.example.concordiaforstudents

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Switch
import android.widget.Spinner
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.concordiaforstudents.R

class Settings : Fragment() {

    private lateinit var darkModeSwitch: Switch
    private lateinit var languageButton: TextView
    private lateinit var notificationButton: TextView
    private lateinit var logoutButton: TextView
    private lateinit var supportButton: Button
    private lateinit var settingsContainer: ViewGroup
    private lateinit var imageViewLanguage: ImageView
    private lateinit var imageViewNotification: ImageView
    private lateinit var imageViewLogout: ImageView
    private lateinit var notificationOptionButton: TextView
    private lateinit var languageOptionButton: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)
        settingsContainer = view.findViewById(R.id.settingsContainer)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize views
        darkModeSwitch = view.findViewById(R.id.darkModeSwitch)
        languageButton = view.findViewById(R.id.languageButton)
        notificationButton = view.findViewById(R.id.notificationButton)
        logoutButton = view.findViewById(R.id.logoutButton)
        supportButton = view.findViewById(R.id.supportButton)
        imageViewLanguage = view.findViewById(R.id.arrowLanguage)
        imageViewNotification = view.findViewById(R.id.arrownotification)
        imageViewLogout = view.findViewById(R.id.arrowLogout)
        notificationOptionButton = view.findViewById(R.id.notificationOptionButton)
        languageOptionButton = view.findViewById(R.id.languageOptionButton)

        darkModeSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                enableDarkMode()
            } else {
                disableDarkMode()
            }
        }

        val languages = arrayOf("English", "French")
        val adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, languages)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Set click listener for language button
        languageButton.setOnClickListener {
            // Handle language button click here
        }

        // Set click listener for notification button
        notificationButton.setOnClickListener {
            // Handle notification button click here
        }

        // Set click listener for logout button
        logoutButton.setOnClickListener {
            // Handle logout button click here
        }

        // Set click listener for support button
        supportButton.setOnClickListener {
            // Handle support button click here
        }
    }


    private fun enableDarkMode() {
        // Change background back to normal when dark mode is disabled
        settingsContainer.setBackgroundColor(resources.getColor(android.R.color.system_background_dark))

        // Set text color back to normal for relevant TextViews
        logoutButton.setTextColor(resources.getColor(R.color.darkmodetext))
        darkModeSwitch.setTextColor(resources.getColor(R.color.darkmodetext))
        notificationButton.setTextColor(resources.getColor(R.color.darkmodetext))
        languageButton.setTextColor(resources.getColor(R.color.darkmodetext))
        supportButton.setTextColor(resources.getColor(R.color.darkmodetext))
        languageOptionButton.setTextColor(resources.getColor(R.color.darkmodetext))
        notificationOptionButton.setTextColor(resources.getColor(R.color.darkmodetext))

        // Set tint for the ImageView
        imageViewLanguage.setColorFilter(resources.getColor(R.color.darkmodetext))
        imageViewLogout.setColorFilter(resources.getColor(R.color.darkmodetext))
        imageViewLogout.setColorFilter(resources.getColor(R.color.darkmodetext))
        imageViewNotification.setColorFilter(resources.getColor(R.color.darkmodetext))

    }

    private fun disableDarkMode() {
        // Change background back to normal when dark mode is disabled
        settingsContainer.setBackgroundColor(resources.getColor(android.R.color.white))

        // Set text color back to normal for relevant TextViews
        logoutButton.setTextColor(resources.getColor(R.color.burgundy))
        darkModeSwitch.setTextColor(resources.getColor(R.color.burgundy))
        notificationButton.setTextColor(resources.getColor(R.color.burgundy))
        languageButton.setTextColor(resources.getColor(R.color.burgundy))
        supportButton.setTextColor(resources.getColor(R.color.burgundy))
        languageOptionButton.setTextColor(resources.getColor(R.color.burgundy))
        notificationOptionButton.setTextColor(resources.getColor(R.color.burgundy))

        // settingsTitle.setBackgroundColor(requireContext().getColor(R.color.burgundy))

        // Set tint for the ImageView
        imageViewLanguage.setColorFilter(resources.getColor(R.color.burgundy))
        imageViewLogout.setColorFilter(resources.getColor(R.color.burgundy))
        imageViewLogout.setColorFilter(resources.getColor(R.color.burgundy))
        imageViewNotification.setColorFilter(resources.getColor(R.color.burgundy))


    }

}
