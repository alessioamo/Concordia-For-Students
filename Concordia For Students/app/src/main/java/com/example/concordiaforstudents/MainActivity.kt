package com.example.concordiaforstudents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.concordiaforstudents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //replaceFragment(Me())

        binding.bottomNavigationView.setOnItemSelectedListener {
            Log.d("TAG", "hello")
            when(it.itemId) {
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


    }

    private fun replaceFragment(fragment : Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()
    }
}