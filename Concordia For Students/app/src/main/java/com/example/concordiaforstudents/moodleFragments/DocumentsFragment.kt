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

class DocumentsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_moodle_documents, container, false)

        val listView = view.findViewById<ListView>(R.id.list_view_documents)
        val names = arrayOf("Lecture 1", "Lecture 2", "Lecture 3","Lecture 4",
            "Lecture 5", "Lecture 6", "Lecture 7", "Lecture 8",)

        val icons = arrayOf(
            R.drawable.baseline_pdf_24,
            R.drawable.baseline_pdf_24,
            R.drawable.baseline_pdf_24,
            R.drawable.baseline_pdf_24,
            R.drawable.baseline_pdf_24,
            R.drawable.baseline_pdf_24,
            R.drawable.baseline_pdf_24,
            R.drawable.baseline_pdf_24,
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
            0 -> LectureFragment()
            1 -> LectureFragment()
            2 -> LectureFragment()
            3 -> LectureFragment()
            4 -> LectureFragment()
            5 -> LectureFragment()
            6 -> LectureFragment()
            7 -> LectureFragment()

            // Add more cases as needed
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
        transaction.replace(R.id.frameLayout, fragment)
        transaction.addToBackStack(null)  // Optional: Add to back stack if you want to navigate back
        transaction.commit()
    }

}