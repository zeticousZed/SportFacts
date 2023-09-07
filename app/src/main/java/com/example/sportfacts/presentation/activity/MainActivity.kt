package com.example.sportfacts.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.sportfacts.R
import com.example.sportfacts.presentation.fragments.SportListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            navigationFragment(R.id.fragmentContainerView,SportListFragment())
        }
    }
    fun navigationFragment(container:Int,fragment:Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(container,fragment)
            .commit()
    }
}