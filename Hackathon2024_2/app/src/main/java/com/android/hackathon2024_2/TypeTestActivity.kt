package com.android.hackathon2024_2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.android.hackathon2024_2.databinding.ActivityTypeTestBinding

class TypeTestActivity : BaseActivity() {
    private lateinit var binding: ActivityTypeTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTypeTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setWindowInsets(binding)

        // ViewPager2와 Adapter 설정
        val adapter = TestViewPagerAdapter(this)
        binding.testViewPager.adapter = adapter
    }
}