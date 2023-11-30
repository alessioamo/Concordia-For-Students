package com.example.concordiaforstudents

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.example.concordiaforstudents.adapters.CustomArrayAdapter
import com.example.concordiaforstudents.moodleFragments.PreferencesFragment
import com.example.concordiaforstudents.moodleFragments.CompetenciesFragment
import com.example.concordiaforstudents.moodleFragments.DashboardFragment
import com.example.concordiaforstudents.moodleFragments.DocumentsFragment
import com.example.concordiaforstudents.moodleFragments.MessagesFragment
import com.example.concordiaforstudents.moodleFragments.OtherClassesFragment
import com.example.concordiaforstudents.moodleFragments.GradesFragment
import com.example.concordiaforstudents.moodleFragments.ParticipantsFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Moodle.newInstance] factory method to
 * create an instance of this fragment.
 */
class Moodle : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_moodle, container, false)

        val listView = view.findViewById<ListView>(R.id.list_view_moodle)
        val names = arrayOf("Documents", "Grades", "Participants", "Competencies", "Messages",
            "Preferences", "Dashboard","Other Classes")

        val icons = arrayOf(
            R.drawable.baseline_article_24,
            R.drawable.baseline_percent_24,
            R.drawable.baseline_people_24,
            R.drawable.baseline_checklist_24,
            R.drawable.baseline_message_24,
            R.drawable.baseline_settings_applications_24,
            R.drawable.baseline_dashboard_24,
            R.drawable.baseline_class_24
            // Add more icon resource IDs as needed
        )

//        val customAdapter = CustomArrayAdapter(requireActivity(), R.layout.list_item, names, icons)
        val customAdapter = CustomArrayAdapter(requireActivity(), R.layout.list_item, names,icons)
        listView.adapter = customAdapter

//        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(
//            requireActivity(), R.layout.list_item, names
//        )
//        listView.adapter = arrayAdapter

        listView.setOnItemClickListener { parent, view, position, id ->
            Log.d("TAG", "Item Selected: " + names[position])

            navigateToFragment(position)
        }

        return view
    }

    private fun navigateToFragment(position: Int) {
        val fragmentManager = requireActivity().supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        Log.d("TAG", "Position: $position")
        // Use a when statement to determine which fragment to navigate to based on position
        val fragment = when (position) {
            0 -> DocumentsFragment()
            1 -> GradesFragment()
            2 -> ParticipantsFragment()
            3 -> CompetenciesFragment()
            4 -> MessagesFragment()
            5 -> PreferencesFragment()
            6 -> DashboardFragment()
            7 -> OtherClassesFragment()
            // Add more cases as needed
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
        transaction.replace(R.id.frameLayout, fragment)
        transaction.addToBackStack(null)  // Optional: Add to back stack if you want to navigate back
        transaction.commit()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Moodle.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Moodle().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}