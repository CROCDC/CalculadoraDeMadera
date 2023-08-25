package com.cr.o.cdc.woodencalculator.ui

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.com.cr.o.cdc.woodencalculator.R
import com.com.cr.o.cdc.woodencalculator.databinding.ActivitySquarePriceBinding
import com.cr.o.cdc.woodencalculator.vm.SquarePriceViewModel

class SquarePriceActivity : CalculateActivity() {

    private val viewModel: SquarePriceViewModel by viewModels { SquarePriceViewModel.FACTORY }

    private lateinit var binding: ActivitySquarePriceBinding
    override val txtPrice: TextView
        get() = binding.txtPrice

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_square_price)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_square_price)
        binding.inputInchesThickness.addIntChangedListener {
            viewModel.setInchesThickness(it)
        }
        binding.inputInchesWidth.addIntChangedListener {
            viewModel.setInchesWidth(it)
        }
        binding.inputPriceWood.addIntChangedListener {
            viewModel.setPriceInches(it)
        }
        binding.btnCalculate.setOnClickListener {
            showPrice(viewModel.calculatePrice())
        }
    }
}