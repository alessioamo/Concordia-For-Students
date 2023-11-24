package com.example.concordiaforstudents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.concordiaforstudents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Me())

        binding.bottomNavigationView.setOnItemSelectedListener {
            Log.d("TAG", "hello")
            when (it.itemId) {
                R.id.me -> replaceFragment(Me())
                R.id.moodle -> replaceFragment(Moodle())
                R.id.campus -> replaceFragment(Campus())
                R.id.settings -> replaceFragment(Settings())

                else -> {
                    Log.d("TAG", "message")
                }
            }
            true
        }

//        val listView = findViewById<ListView>(R.id.list_view_me)
//        val names = arrayOf("1", "2", "3", "4", "5", "6")
//        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(
//            this, android.R.layout.simple_list_item_1, names
//        )
//        listView.adapter = arrayAdapter
//
//        listView.setOnItemClickListener { parent, view, position, id ->
//           // Toast.makeText(this, "Item Selected: " + names[position], Toast.LENGTH_LONG)
//            Log.d("TAG", "Item Selected: " + names[position])
//        }

    }

    private fun replaceFragment(fragment : Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()
    }
}