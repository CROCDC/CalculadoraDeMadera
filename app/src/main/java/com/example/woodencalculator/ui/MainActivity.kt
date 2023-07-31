package com.example.woodencalculator.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import com.example.woodencalculator.R
import com.example.woodencalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        binding.btnSquare.setOnClickListener {
            startActivity(Intent(this, SquarePriceActivity::class.java))
        }
        binding.btnRectangle.setOnClickListener {
            startActivity(Intent(this, RectanglePriceActivity::class.java))
        }
    }
}
