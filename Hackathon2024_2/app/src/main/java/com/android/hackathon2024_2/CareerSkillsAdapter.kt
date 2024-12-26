package com.android.hackathon2024_2

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CareerSkillsAdapter(
    private val dataList: List<CareerSkillsData>,
    private val onItemClick: (CareerSkillsData) -> Unit // 클릭 이벤트 리스너 추가
) : RecyclerView.Adapter<CareerSkillsAdapter.ViewHolder>() {

    // ViewHolder 클래스 정의
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val contentTextView: TextView = view.findViewById(R.id.question_title)
        val dateTextView: TextView = view.findViewById(R.id.skill_date)
        val scoreTextView: TextView = view.findViewById(R.id.skill_info)
    }

    // ViewHolder 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_career_skills, parent, false)
        return ViewHolder(view)
    }

    // 데이터 바인딩
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]

        // 텍스트 설정
        holder.contentTextView.text = data.content
        holder.dateTextView.text = data.date
        holder.scoreTextView.text = data.score

        // 합격/불합격 색상 처리
        when (data.score) {
            "합격" -> holder.scoreTextView.setTextColor(Color.BLUE)
            "불합격" -> holder.scoreTextView.setTextColor(Color.RED)
            else -> holder.scoreTextView.setTextColor(Color.BLACK) // 기본 색상
        }

        // 아이템 클릭 이벤트 설정
        holder.itemView.setOnClickListener {
            onItemClick(data)
        }
    }

    // 아이템 개수 반환
    override fun getItemCount(): Int {
        return dataList.size
    }
}
