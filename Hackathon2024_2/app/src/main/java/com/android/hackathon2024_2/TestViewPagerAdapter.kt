package com.android.hackathon2024_2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TestViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 4 // 총 탭 개수
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> QuestionListFragment.newInstance(0)
            1 -> QuestionListFragment.newInstance(1)
            2 -> QuestionListFragment.newInstance(2)
            3 -> TestResultFragment()
            else -> throw IllegalStateException("Unexpected position $position")
        }
    }
}