package com.example.woodencalculator.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import com.example.woodencalculator.R
import com.example.woodencalculator.databinding.ActivityRectanglePriceBinding
import com.example.woodencalculator.utils.toInt
import com.example.woodencalculator.vm.RectanglePriceViewModel

class RectanglePriceActivity : AppCompatActivity() {

    private val viewModel: RectanglePriceViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rectangle_price)
        val binding: ActivityRectanglePriceBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_rectangle_price
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
        binding.inputInchesLarge.addTextChangedListener {
            try {
                viewModel.setInchesLarge(it.toInt())
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
            val price = viewModel.calculatePrice()
            if (price != null) {
                binding.txtPrice.text = getString(R.string.price_this, viewModel.calculatePrice())
            } else {
                binding.txtPrice.setText(R.string.price_calculate_fail)
            }
        }
    }
}