package com.example.concordiaforstudents.meFragments


import android.os.Bundle
import android.view.*
import android.widget.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.concordiaforstudents.R

class CourseRegistrationFragment : Fragment() {

    private val courses =
        mutableListOf(
            Course(0, "COMP", "335"),
            Course(1, "COMP", "346"),
            Course(2, "SOEN", "341"),
            Course(3, "SOEN", "342"),
            Course(4, "SOEN", "357"),
            Course(5, "SOEN", "363")
            )
    private val courseTitles = mutableListOf("COMP 335", "COMP 346", "SOEN 341", "SOEN 342", "SOEN 357", "SOEN 363")
    private val registeredCourses = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_courseregistration, container, false)
        val courseSpinner: Spinner = view.findViewById(R.id.courseSpinner)
        val registeredCoursesListView: ListView = view.findViewById(R.id.chosenCoursesListView)
        val addCourseFab: FloatingActionButton = view.findViewById(R.id.addCourseBtn)
        val removeCoursesBtn: Button = view.findViewById(R.id.removeCoursesBtn)

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, courseTitles)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        courseSpinner.adapter = adapter

        addCourseFab.setOnClickListener {
            courseSpinner.visibility = View.VISIBLE
        }

        courseSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedCourse = courses[position]
                registeredCourses.add(selectedCourse.program + " " + selectedCourse.number)
                updateRegisteredCoursesList(registeredCoursesListView)

                courses.removeAt(position)
                courseTitles.removeAt(position)
                adapter.notifyDataSetChanged()

                courseSpinner.visibility = View.GONE
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // handles nothing selected if needed
            }
        }

        removeCoursesBtn.setOnClickListener {
            val selectedCourses = registeredCoursesListView.checkedItemPositions

            val coursesToRemove = mutableListOf<Course>()

            for (i in selectedCourses.size() - 1 downTo 0) {
                if (selectedCourses.valueAt(i)) {
                    val course = registeredCourses[i]
                    val program = course.split("\\s".toRegex())[0]
                    val courseNum = course.split("\\s".toRegex())[1]
                    coursesToRemove.add(Course(0, program, courseNum))
                }
            }

            registeredCourses.removeAll(coursesToRemove.map { "${it.program} ${it.number}" })

            courses.addAll(coursesToRemove)
            courseTitles.addAll(coursesToRemove.map { "${it.program} ${it.number}" })

            updateRegisteredCoursesList(registeredCoursesListView)
            adapter.notifyDataSetChanged()
        }

        return view
    }

    private fun updateRegisteredCoursesList(listView: ListView) {
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_multiple_choice, registeredCourses)
        listView.adapter = adapter
    }
}