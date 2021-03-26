package com.famsbprog.class0310

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), BottomFragment.DisplayText {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun setDisplayText() {

        var topFrag = supportFragmentManager.findFragmentById(R.id.fragment) as TopFragment
        topFrag.changeDisplay()

    }
}