package com.android.hackathon2024_2

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
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
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CustomBottomSheetDialog : BottomSheetDialogFragment() {

    private lateinit var binding: CalendarBtmSheetBinding
    private var seconds = 0
    private var isRunning = false
    private val handler = Handler(Looper.getMainLooper())
    private val timerRunnable = object : Runnable {
        override fun run() {
            if (isRunning) {
                seconds++
                updateTimerText()
                handler.postDelayed(this, 1000)
            }
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        dialog.window?.apply {
            addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND) // 배경 흐리게
            setDimAmount(0.7f) // 흐림 정도
        }

        return dialog
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        dialog.// 배경을 투명하게 설정
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val view = inflater.inflate(R.layout.calendar_btm_sheet, container, false)

        val shutDownBtn = view.findViewById<ImageView>(R.id.shut_dwn_btn)
        shutDownBtn.setOnClickListener {
            dismiss() // 바텀시트 닫기
        }

        val stopBtn = view.findViewById<ImageView>(R.id.stop_btn)
        stopBtn.setOnClickListener {
            toggleTimer(stopBtn)
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

    private fun toggleTimer(button: ImageView) {
        if (isRunning) {
            stopTimer()
            button.setImageResource(R.drawable.start_btn) // 시작 아이콘으로 변경
        } else {
            startTimer()
            button.setImageResource(R.drawable.stop_btn) // 정지 아이콘으로 변경
        }
    }

    private fun startTimer() {
        isRunning = true
        handler.post(timerRunnable)
    }

    private fun stopTimer() {
        isRunning = false
    }

    private fun updateTimerText() {
        val timerTextView = view?.findViewById<TextView>(R.id.tv_timer)
        val hours = seconds / 3600
        val minutes = (seconds % 3600) / 60
        val secs = seconds % 60
        timerTextView?.text = String.format("%02d:%02d:%02d", hours, minutes, secs)
    }
}
