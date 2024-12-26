package com.android.hackathon2024_2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2 // 총 탭 개수
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CalendarFragment() // 첫 번째 탭
            1 -> CareerSkillsFragment() // 두 번째 탭
            else -> throw IllegalStateException("Unexpected position $position")
        }
    }
}
