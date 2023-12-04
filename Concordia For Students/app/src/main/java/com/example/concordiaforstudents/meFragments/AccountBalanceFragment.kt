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

class AccountBalanceFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("AccountBalanceFragment", "onCreateView called")
        val view = inflater.inflate(R.layout.fragment_accountbalance, container, false)

        val text: TextView = view.findViewById(R.id.balanceTextView)

        val inputText = "<b>Account Summary</b><br/>" +
                "<b>    Due Now:</b> 0.00<br/>" +
                "<b>    Future Due:</b> 2765.20<br/><br/>" +
                "<b>You owe 2765.20</b><br/><br/>"

        text.text = HtmlCompat.fromHtml(inputText, HtmlCompat.FROM_HTML_MODE_LEGACY)

        return view
    }
}