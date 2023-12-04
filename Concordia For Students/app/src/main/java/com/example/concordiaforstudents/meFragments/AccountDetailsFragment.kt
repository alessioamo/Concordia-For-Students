package com.example.concordiaforstudents.meFragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import com.example.concordiaforstudents.R

class AccountDetailsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("AccountDetailsFragment", "onCreateView called")

        val view = inflater.inflate(R.layout.fragment_accountdetails, container, false)

        val text: TextView = view.findViewById(R.id.mainTextView)

        val inputText = "<b>Name:</b><br/> John Doe <br/><br/>" +
                        "<b>Student ID:</b><br/> 40254021<br/><br/>" +
                        "<b>Address:</b><br/> 1234 Avenue Street, Montreal, QC<br/><br/>" +
                        "<b>Primary Phone Number:</b><br/> (514) 248-2934<br/><br/>" +
                        "<b>Email:</b><br/> john_doe@gmail.com<br/><br/>"
        text.text = HtmlCompat.fromHtml(inputText, HtmlCompat.FROM_HTML_MODE_LEGACY)

        return view
    }
}