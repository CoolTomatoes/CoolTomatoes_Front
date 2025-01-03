package com.android.hackathon2024_2

import android.graphics.Color
import android.os.Bundle
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePaddingRelative

open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setContentView 전에 Edge to Edge 설정
        enableEdgeToEdge(
            navigationBarStyle = SystemBarStyle.dark(Color.parseColor("#000000"))
        )
    }

    // setContentView 뒤에 WindowInsets 설정
    protected fun setWindowInsets(view: androidx.viewbinding.ViewBinding) {
        ViewCompat.setOnApplyWindowInsetsListener(view.root) { v, insets ->
            val inset = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.updatePaddingRelative(
                bottom = inset.bottom
            )
            insets
        }
    }
}