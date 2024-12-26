package com.android.hackathon2024_2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.hackathon2024_2.databinding.ActivityTestInitBinding

class TestInitActivity : BaseActivity() {
    private lateinit var binding: ActivityTestInitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTestInitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setWindowInsets(binding)

        binding.testStart.setOnClickListener {
            val intent = Intent(this, TypeTestActivity::class.java)
            startActivity(intent)
        }
    }
}