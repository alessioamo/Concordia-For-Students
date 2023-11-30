package com.example.concordiaforstudents

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.example.concordiaforstudents.adapters.CustomArrayAdapter
import com.example.concordiaforstudents.campusFragments.CampusServicesFragment
import com.example.concordiaforstudents.campusFragments.DatesAndEventsFragment
import com.example.concordiaforstudents.campusFragments.FacultyFragment
import com.example.concordiaforstudents.campusFragments.FoodFragment
import com.example.concordiaforstudents.campusFragments.GymFragment
import com.example.concordiaforstudents.campusFragments.LibraryFragment
import com.example.concordiaforstudents.campusFragments.MapsFragment
import com.example.concordiaforstudents.campusFragments.NewsFragment
import com.example.concordiaforstudents.campusFragments.STMScheduleFragment
import com.example.concordiaforstudents.campusFragments.ShoppingFragment
import com.example.concordiaforstudents.campusFragments.ShuttleScheduleFragment
import com.example.concordiaforstudents.meFragments.AccountBalanceFragment
import com.example.concordiaforstudents.meFragments.AccountDetailsFragment
import com.example.concordiaforstudents.meFragments.GradesFragment
import com.example.concordiaforstudents.meFragments.MessagesFragment
import com.example.concordiaforstudents.meFragments.MyConcordiaFragment
import com.example.concordiaforstudents.meFragments.ScheduleFragment
import com.example.concordiaforstudents.meFragments.TaskListFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Campus.newInstance] factory method to
 * create an instance of this fragment.
 */
class Campus : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_campus, container, false)

        val listView = view.findViewById<ListView>(R.id.list_view_campus)
        val names = arrayOf("News", "Dates and Events", "Maps", "Shuttle Schedule", "STM Schedule",
                            "Library", "Campus Services", "Food", "Shopping", "Faculty", "Gym")

        // TODO - Campus icons
        val icons = arrayOf(
            R.drawable.baseline_newspaper_24,
            R.drawable.baseline_calendar_month_24,
            R.drawable.baseline_location_on_24,
            R.drawable.baseline_airport_shuttle_24,
            R.drawable.baseline_train_24,
            R.drawable.baseline_menu_book_24,
            R.drawable.baseline_help_24,
            R.drawable.baseline_fastfood_24,
            R.drawable.baseline_shopping_bag_24,
            R.drawable.baseline_groups_24,
            R.drawable.baseline_directions_run_24,
            // Add more icon resource IDs as needed
        )

        val customAdapter = CustomArrayAdapter(requireActivity(), R.layout.list_item, names, icons)
        listView.adapter = customAdapter

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
            0 -> NewsFragment()
            1 -> DatesAndEventsFragment()
            2 -> MapsFragment()
            3 -> ShuttleScheduleFragment()
            4 -> STMScheduleFragment()
            5 -> LibraryFragment()
            6 -> CampusServicesFragment()
            7 -> FoodFragment()
            8 -> ShoppingFragment()
            9 -> FacultyFragment()
            10 -> GymFragment()
            // TODO - This last fragment is simply to leave a whitespace to allow for scrolling to see the previous item, doesn't work properly yet. Will fix
            11 -> Fragment()
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
         * @return A new instance of fragment Campus.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Campus().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}