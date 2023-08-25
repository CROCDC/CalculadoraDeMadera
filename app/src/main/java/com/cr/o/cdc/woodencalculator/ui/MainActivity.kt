package com.cr.o.cdc.woodencalculator.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.com.cr.o.cdc.woodencalculator.R
import com.com.cr.o.cdc.woodencalculator.databinding.ActivityMainBinding
import com.cr.o.cdc.woodencalculator.analitycs.Events
import com.cr.o.cdc.woodencalculator.analitycs.MyFirebaseAnalyticsImp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val analytics = MyFirebaseAnalyticsImp.create(this)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        binding.btnSquare.setOnClickListener {
            analytics.trackEvent(Events.GO_TO_SQUARE)
            startActivity(Intent(this, SquarePriceActivity::class.java))
        }
        binding.btnRectangle.setOnClickListener {
            analytics.trackEvent(Events.GO_TO_RECTANGLE)
            startActivity(Intent(this, RectanglePriceActivity::class.java))
        }
    }
}
