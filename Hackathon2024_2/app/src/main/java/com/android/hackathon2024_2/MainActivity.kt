package com.android.hackathon2024_2

import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.android.hackathon2024_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showInit()
        initBottomNav()

        //setStatusBarTransparent()
    }

    fun setStatusBarTransparent() {
        window.apply {
            setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
        if (Build.VERSION.SDK_INT >= 30) {    // API 30에 적용
            WindowCompat.setDecorFitsSystemWindows(window, false)
        }
    }

    private fun initBottomNav() {
        binding.bottomNavigationView.itemIconTintList = null

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.fragment_home -> {
                    HomeFragment().changeFragment()
                    true
                }

                R.id.fragment_record -> {
                    RecordFragment().changeFragment()
                    true
                }

                R.id.fragment_report -> {
                    ReportFragment().changeFragment()
                    true
                }

                R.id.fragment_mypage -> {
                    MyPageFragment().changeFragment()
                    true
                }

                else -> false
            }
        }

        binding.bottomNavigationView.setOnItemReselectedListener {
            // 바텀네비 재클릭시 화면 재생성 방지
        }
    }

    private fun Fragment.changeFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, this)
            .commit()
    }

    private fun showInit() {
        val transaction = supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, HomeFragment())
        transaction.commit()
    }
}