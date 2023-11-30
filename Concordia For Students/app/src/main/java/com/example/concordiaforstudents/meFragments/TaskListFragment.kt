package com.example.concordiaforstudents.meFragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.concordiaforstudents.R

class TaskListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("TaskListFragment", "onCreateView called")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tasklist, container, false)
    }
}