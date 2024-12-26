package com.android.hackathon2024_2

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import com.android.hackathon2024_2.databinding.CalendarBtmSheetBinding
import com.android.hackathon2024_2.databinding.CareerSkillsBtmSheetBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CustomBtmSheetDialog2: BottomSheetDialogFragment() {

    private lateinit var binding: CareerSkillsBtmSheetBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): BottomSheetDialog {
        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog

        // 뒷배경 흐리게 설정
        dialog.window?.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        dialog.window?.setDimAmount(0.5f) // 흐림 정도 (0.0f ~ 1.0f)

        return dialog
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.career_skills_btm_sheet, container, false)

        val shutDownBtn = view.findViewById<ImageView>(R.id.shut_dwn_btn)
        shutDownBtn.setOnClickListener {
            dismiss() // 바텀시트 닫기
        }

        return view
    }

    override fun onStart() {
        super.onStart()

        // 바텀시트의 높이 조정
        dialog?.let { dialog ->
            val bottomSheet = dialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            bottomSheet?.let {
                val layoutParams = it.layoutParams
                layoutParams.height = (669 * resources.displayMetrics.density).toInt() // 669dp로 설정
                it.layoutParams = layoutParams

                // BottomSheetBehavior 조정
                val behavior = BottomSheetBehavior.from(it)
                behavior.state = BottomSheetBehavior.STATE_EXPANDED // 기본 확장 상태로 설정
                behavior.skipCollapsed = true // 접힘 상태를 생략
            }
        }
    }

}
