package com.android.hackathon2024_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.hackathon2024_2.databinding.FragmentCareerSkillsBinding

class CareerSkillsFragment : Fragment() {

    private var _binding: FragmentCareerSkillsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCareerSkillsBinding.inflate(inflater, container, false)

        // RecyclerView 설정
        setupRecyclerView()

        binding.floatingActionBtn2.setOnClickListener {
            val bottomSheet = CustomBtmSheetDialog2()
            bottomSheet.show(requireActivity().supportFragmentManager, "RecordBottomSheet")
        }

        return binding.root
    }

    private fun setupRecyclerView() {
        val sampleData = listOf(
            CareerSkillsData("토익 (TOEIC)", "2024/05/11 응시", "800점"),
            CareerSkillsData("토익 (TOEIC)", "2024/04/13 응시", "660점"),
            CareerSkillsData("컴퓨터 활용 능력", "2024/05/11 응시", "합격"),
            CareerSkillsData("컴퓨터 활용 능력", "2024/03/27 응시", "불합격")
        )

        // 리사이클러뷰 연결
        val adapter = CareerSkillsAdapter(sampleData) { data ->
            // 클릭 이벤트 처리
            //Toast.makeText(context, "${data.content} 클릭됨", Toast.LENGTH_SHORT).show()
        }

        binding.rcvCareerSkills.layoutManager = LinearLayoutManager(context)
        binding.rcvCareerSkills.adapter = adapter

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
