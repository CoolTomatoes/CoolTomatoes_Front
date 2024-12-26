package com.android.hackathon2024_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.hackathon2024_2.databinding.FragmentRecordBinding
import com.google.android.material.tabs.TabLayoutMediator

class RecordFragment : Fragment() {

    private var _binding: FragmentRecordBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecordBinding.inflate(inflater, container, false)

        setupViewPagerAndTabs()

        return binding.root
    }

    private fun setupViewPagerAndTabs() {
        // ViewPagerAdapter 설정
        val viewPagerAdapter = ViewPagerAdapter(requireActivity())
        binding.viewPager.adapter = viewPagerAdapter

        // TabLayout과 ViewPager 연결
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "캘린더" // 첫 번째 탭 이름
                1 -> "자격증/대외활동" // 두 번째 탭 이름
                else -> null
            }
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}