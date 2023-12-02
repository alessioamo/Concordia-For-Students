package com.example.concordiaforstudents.moodleFragments
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.concordiaforstudents.R
import com.example.concordiaforstudents.adapters.CustomArrayAdapter

class OtherClassesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("OtherClassesFragment", "onCreateView called")
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_moodle_otherclasses, container, false)

        val listView = view.findViewById<ListView>(R.id.list_view_otherclasses)
        val names = arrayOf("ENGR 301 H 2232", "SOEN 384 F,G 2232", "SOEN 321 GG 2232")

        val icons = arrayOf(
            R.drawable.baseline_playlist_24,
            R.drawable.baseline_playlist_24,
            R.drawable.baseline_playlist_24
            // Add more icon resource IDs as needed
        )

//        val customAdapter = CustomArrayAdapter(requireActivity(), R.layout.list_item, names, icons)
        val customAdapter = CustomArrayAdapter(requireActivity(), R.layout.list_item, names,icons)
        listView.adapter = customAdapter

//        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(
//            requireActivity(), R.layout.list_item, names
//        )
//        listView.adapter = arrayAdapter

        return view
    }
}