package com.example.ukllagi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class FragmentBar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_bar)

        val viewPager = findViewById<ViewPager>(R.id.ViewPager)
        val tabLayout = findViewById<TabLayout>(R.id.TabLayout)

        viewPager.adapter = PagerAdapter(this, supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
    }
}