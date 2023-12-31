package com.example.concordiaforstudents.meFragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.concordiaforstudents.R

class TaskListFragment : Fragment() {

    private lateinit var taskList1: ListView
    private lateinit var taskList2: ListView
    private lateinit var taskList3: ListView
    private lateinit var tasks1: List<Map<String, String>>
    private lateinit var tasks2: List<Map<String, String>>
    private lateinit var tasks3: List<Map<String, String>>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tasklist, container, false)

        taskList1 = view.findViewById(R.id.task_list1)
        taskList2 = view.findViewById(R.id.task_list2)
        taskList3 = view.findViewById(R.id.task_list3)

        tasks1 = listOf(
            createTaskMap("Romeo and Juliet Essay", "Philisophy"),
            createTaskMap("Functions Quiz", "Maths"),
            createTaskMap("Textbook ch. 3", "Machine Learning")
        )

        tasks2 = listOf(
            createTaskMap("Subjunctive Worksheet", "English"),
            createTaskMap("Anatomy Group Project", "Biology"),
            createTaskMap("World Religions Test", "Philosophy")
        )

        tasks3 = listOf(
            createTaskMap("Oil Painting", "English")
        )

        val adapter1 = SimpleAdapter(
            requireContext(),
            tasks1,
            android.R.layout.simple_list_item_2,
            arrayOf("task", "subtask"),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        )
        val adapter2 = SimpleAdapter(
            requireContext(),
            tasks2,
            android.R.layout.simple_list_item_2,
            arrayOf("task", "subtask"),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        )
        val adapter3 = SimpleAdapter(
            requireContext(),
            tasks3,
            android.R.layout.simple_list_item_2,
            arrayOf("task", "subtask"),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        )

        taskList1.adapter = adapter1
        taskList2.adapter = adapter2
        taskList3.adapter = adapter3

        // Set background color for the colored views
        setColoredViewBackground(view, R.id.side_color1, Color.RED)
        setColoredViewBackground(view, R.id.side_color2, Color.BLUE)
        setColoredViewBackground(view, R.id.side_color3, Color.MAGENTA)
        setColoredViewBackground(view, R.id.side_color1_list2, Color.YELLOW)
        setColoredViewBackground(view, R.id.side_color2_list2, Color.GREEN)
        setColoredViewBackground(view, R.id.side_color1_list3, Color.YELLOW)

        return view
    }

    private fun createTaskMap(task: String, subtask: String): Map<String, String> {
        val taskMap = HashMap<String, String>()
        taskMap["task"] = task
        taskMap["subtask"] = subtask
        return taskMap
    }

    private fun setColoredViewBackground(view: View, resourceId: Int, color: Int) {
        val coloredView = view.findViewById<View>(resourceId)
        coloredView.setBackgroundColor(color)
    }
}
