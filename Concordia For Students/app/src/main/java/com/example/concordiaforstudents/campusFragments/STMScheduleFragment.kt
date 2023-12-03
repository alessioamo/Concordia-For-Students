package com.example.concordiaforstudents.campusFragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.example.concordiaforstudents.R

class STMScheduleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("STMScheduleFragment", "onCreateView called")
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_stmschedule, container, false)

        // Initialize spinners
        val metroSpinner = view.findViewById<Spinner>(R.id.metroSpinner)
        val metroSpinnerStation = view.findViewById<Spinner>(R.id.metroSpinnerStation)

        // Define values for spinners
        val colors = arrayOf("Orange", "Green", "Blue", "Yellow")
        val stations = arrayOf("Côte-Vertu", "Du Collège", "De la Savane", "Namur", "Plamondon", "Côte-Sainte-Catherine", "Snowdon", "Villa-Maria", "Vendôme", "Place-Saint-Henri", "Lionel-Groulx", "Georges-Vanier", "Lucien-L'Allier", "Bonaventure", "Square-Victoria–OACI", "Place-d'Armes", "Champ-de-Mars", "Berri-UQAM", "Sherbrooke", "Mont-Royal", "Laurier", "Rosemont", "Beaubien", "Jean-Talon", "Jarry", "Crémazie", "Sauvé", "Henri-Bourassa", "Cartier", "De La Concorde", "Montmorency")

        // Create ArrayAdapter for spinners
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, colors)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        val adapter2 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, stations)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Set adapters to spinners
        metroSpinner.adapter = adapter
        metroSpinnerStation.adapter = adapter2
        metroSpinnerStation.setSelection(stations.indexOf("Berri-UQAM"))

        return view
    }
}