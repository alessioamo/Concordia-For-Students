package com.example.concordiaforstudents.moodleFragments
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.fragment.app.Fragment
import com.example.concordiaforstudents.R

class MessagesFragment : Fragment() {

    private lateinit var msglist: ListView
    private lateinit var msgs: List<Map<String, String>>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_moodle_messages, container, false)

        msglist = view.findViewById(R.id.moodle_msglist)

        msgs = listOf(
            createMsgMap("Hank Caulson","Regarding the assignment, you lef...."),
            createMsgMap("Ellie Paolo","Did you see the grade we got fo..."),
            createMsgMap("Jeannie Khan", "Can you ask the TA to double ch..."),
            createMsgMap("Tobias Mata","when's your last exam for this semes...")
        )

        val adapter1 = SimpleAdapter(
            requireContext(),
            msgs,
            android.R.layout.simple_list_item_2,
            arrayOf("recipient","msg"),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        )
        msglist.adapter = adapter1

        msglist.setOnItemClickListener { parent, view, position, id ->
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
            0 -> ClickedMessageFragment()
            1 -> ClickedMessageFragment()
            2 -> ClickedMessageFragment()
            3 -> ClickedMessageFragment()

            // Add more cases as needed
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
        transaction.replace(R.id.frameLayout, fragment)
        transaction.addToBackStack(null)  // Optional: Add to back stack if you want to navigate back
        transaction.commit()
    }
    private fun createMsgMap(recipient: String, msg: String): Map<String, String> {
        val msgMap = HashMap<String, String>()
        msgMap["recipient"] = recipient
        msgMap["msg"] = msg
        return msgMap
    }
}