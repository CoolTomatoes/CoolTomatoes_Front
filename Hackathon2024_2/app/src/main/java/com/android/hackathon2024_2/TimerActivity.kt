package com.android.hackathon2024_2

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.android.hackathon2024_2.databinding.ActivityTimerBinding

class TimerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTimerBinding
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTimerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener { startTimer() }
        binding.btnStop.setOnClickListener { stopTimer() }
        binding.btnReset.setOnClickListener { resetTimer() }
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(timerRunnable) // 메모리 누수 방지
    }

    private fun startTimer() {
        if (!isRunning) {
            isRunning = true
            handler.post(timerRunnable)
        }
    }

    private fun stopTimer() {
        isRunning = false
    }

    private fun resetTimer() {
        isRunning = false
        seconds = 0
        updateTimerText()
    }

    private fun updateTimerText() {
        val hours = seconds / 3600
        val minutes = (seconds % 3600) / 60
        val secs = seconds % 60
        binding.tvTimer.text = String.format("%02d:%02d:%02d", hours, minutes, secs)
    }
}
