package com.example.concordiaforstudents

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.example.concordiaforstudents.adapters.CustomArrayAdapter
import com.example.concordiaforstudents.meFragments.AccountBalanceFragment
import com.example.concordiaforstudents.meFragments.AccountDetailsFragment
import com.example.concordiaforstudents.meFragments.GradesFragment
import com.example.concordiaforstudents.meFragments.CourseRegistrationFragment
import com.example.concordiaforstudents.meFragments.MyConcordiaFragment
import com.example.concordiaforstudents.meFragments.ScheduleFragment
import com.example.concordiaforstudents.meFragments.TaskListFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Me.newInstance] factory method to
 * create an instance of this fragment.
 */
class Me : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_me, container, false)

        val listView = view.findViewById<ListView>(R.id.list_view_me)
        val names = arrayOf("Schedule", "Grades", "Course Registration", "MyConcordia", "Task List", "Account Details", "Account Balance")

        val icons = arrayOf(
            R.drawable.baseline_calendar_month_24,
            R.drawable.baseline_percent_24,
            R.drawable.baseline_app_registration_24,
            R.drawable.baseline_web_24,
            R.drawable.baseline_checklist_24,
            R.drawable.baseline_account_circle_24,
            R.drawable.baseline_attach_money_24,
            // Add more icon resource IDs as needed
        )

        val customAdapter = CustomArrayAdapter(requireActivity(), R.layout.list_item, names, icons)
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
            0 -> ScheduleFragment()
            1 -> GradesFragment()
            2 -> CourseRegistrationFragment()
            3 -> MyConcordiaFragment()
            4 -> TaskListFragment()
            5 -> AccountDetailsFragment()
            6 -> AccountBalanceFragment()
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
         * @return A new instance of fragment Me.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Me().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}