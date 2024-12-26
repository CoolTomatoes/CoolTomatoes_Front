package com.android.hackathon2024_2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.android.hackathon2024_2.databinding.FragmentQuestionListBinding

class QuestionListFragment : Fragment() {
    private var _binding: FragmentQuestionListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuestionListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 인자로 전달된 position 값을 가져옴
        val position = arguments?.getInt(ARG_POSITION) ?: 0

        // 샘플 데이터 생성
        val questionList = when (position) {
            0 -> listOf(
                QuestionData("구체적 경험과 반성적 관찰을 선호합니다."),
                QuestionData("현실에 대한 직관과 고찰을 자주 합니다."),
                QuestionData("많은 생각을 일반화하는 경향이 있습니다."),
                QuestionData("폭넓은 문화에 흥미가 많습니다."),
                QuestionData("통합적으로 사고하는 편입니다."),
                QuestionData("감정에 기반한 개방적 사고를 즐깁니다."),
                QuestionData("제한이 많은 환경을 거부합니다."),
                QuestionData("또래 간 상호 활동을 거부합니다."),
                QuestionData("노트 필기를 중시하지 않습니다."),
                QuestionData("추상적 개념화와 반성적 관찰을 선호합니다."),
                QuestionData("논리적이고 정확적 사고를 합니다.")
            )
            1 -> listOf(
                QuestionData("이론적 모델을 세우는 데 익숙합니다."),
                QuestionData("귀납적 추론을 잘합니다."),
                QuestionData("행동보다 사고와 이해에 초점을 둡니다."),
                QuestionData("규칙이나 지시를 잘 따릅니다."),
                QuestionData("강의 방식을 노트 필기를 중시합니다."),
                QuestionData("새로운 방식으로 문제를 해결하려 합니다."),
                QuestionData("창의적인 접근을 즐깁니다."),
                QuestionData("감정보다는 논리에 따라 행동합니다."),
                QuestionData("실험을 통해 배우는 것을 선호합니다."),
                QuestionData("구체적인 목표를 세우고 이를 달성하려 노력합니다."),
                QuestionData("문제를 깊이 분석하고 싶어 합니다.")
            )
            2 -> listOf(
                QuestionData("팀 프로젝트를 즐깁니다."),
                QuestionData("스스로 배우는 환경을 선호합니다."),
                QuestionData("다양한 관점에서 문제를 바라보는 것을 선호합니다."),
                QuestionData("스스로 계획을 세우고 실행하는 것을 좋아합니다."),
                QuestionData("협업보다 독립적으로 학습하는 것을 좋아합니다."),
                QuestionData("새로운 아이디어를 현실화하는 데 관심이 많습니다."),
                QuestionData("목표를 세우고 이를 체계적으로 달성하려 합니다."),
                QuestionData("실질적인 해결책을 찾는 데 집중합니다."),
                QuestionData("도전적인 환경에서 학습하는 것을 선호합니다."),
                QuestionData("경험을 통해 배우는 것이 효과적이라고 생각합니다.")
            )
            else -> emptyList()
        }

        // RecyclerView 설정
        val adapter = QuestionAdapter(questionList)
        binding.rcvQuestion.layoutManager = LinearLayoutManager(context)
        binding.rcvQuestion.adapter = adapter

        // ViewPager2 참조
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)

        // 버튼 클릭 시 다음 페이지로 이동
        binding.questionNextBtn.setOnClickListener {
            val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)
            viewPager?.let {
                it.currentItem = it.currentItem + 1
            } ?: run {
                // viewPager가 null인 경우 처리
                Log.e("QuestionListFragment", "ViewPager is null")
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_POSITION = "position"

        @JvmStatic
        fun newInstance(position: Int) =
            QuestionListFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_POSITION, position)
                }
            }
    }
}