package com.example.ukllagi

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagerAdapter(private val nContext: Context, fm: FragmentManager): FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        return if (position == 0) {
            SignUp.newInstance()
        }else {
            ProfilResult.newInstance()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return nContext.resources.getString(Titles[position])
    }

    companion object {
        private val Titles = intArrayOf(R.string.signup, R.string.profile)
    }

}