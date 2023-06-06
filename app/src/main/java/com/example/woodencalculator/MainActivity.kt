package com.example.woodencalculator

import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import com.example.woodencalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        binding.inputInchesThickness.addTextChangedListener {
            try {
                viewModel.setInchesThickness(it.toInt())
            } catch (e: Exception) {
                Toast.makeText(this, R.string.number_warning, Toast.LENGTH_LONG).show()
            }

        }
        binding.inputInchesWidth.addTextChangedListener {
            try {
                viewModel.setInchesWidth(it.toInt())
            } catch (e: Exception) {
                Toast.makeText(this, R.string.number_warning, Toast.LENGTH_LONG).show()
            }
        }
        binding.inputPriceWood.addTextChangedListener {
            try {
                viewModel.setPriceInches(it.toInt())
            } catch (e: Exception) {
                Toast.makeText(this, R.string.number_warning, Toast.LENGTH_LONG).show()
            }
        }
        binding.btnCalculate.setOnClickListener {
            binding.txtPrice.text = getString(R.string.price_this, viewModel.calculatePrice())
        }
    }

    private fun Editable?.toInt() = this.takeIf {
        !it.isNullOrBlank()
    }?.toString()?.toInt()
}