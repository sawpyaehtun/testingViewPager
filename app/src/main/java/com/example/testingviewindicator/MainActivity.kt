package com.example.testingviewindicator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val temparray = resources.getStringArray(R.array.myarray)

        val adapter = ViewPagerAdapter(temparray,this)
        vpPager.adapter = adapter
        spring_dots_indicator.setViewPager(vpPager)
    }

    private fun showToast(message : String)
    {
        Toast.makeText(this@MainActivity,message,Toast.LENGTH_LONG).show();
    }
}
