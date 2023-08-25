package com.cr.o.cdc.woodencalculator.ui

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.com.cr.o.cdc.woodencalculator.R
import com.com.cr.o.cdc.woodencalculator.databinding.ActivityRectanglePriceBinding
import com.cr.o.cdc.woodencalculator.analitycs.MyFirebaseAnalyticsImp
import com.cr.o.cdc.woodencalculator.vm.RectanglePriceViewModel

class RectanglePriceActivity : CalculateActivity() {

    private lateinit var binding: ActivityRectanglePriceBinding
    private val viewModel: RectanglePriceViewModel by viewModels { RectanglePriceViewModel.FACTORY }
    override val txtPrice: TextView
        get() = binding.txtPrice

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rectangle_price)
        binding = DataBindingUtil.setContentView(
            this, R.layout.activity_rectangle_price
        )
        binding.inputInchesThickness.addIntChangedListener {
            viewModel.setInchesThickness(it)
        }
        binding.inputInchesWidth.addIntChangedListener {
            viewModel.setInchesWidth(it)
        }
        binding.inputInchesLarge.addIntChangedListener {
            viewModel.setInchesLarge(it)
        }
        binding.inputPriceWood.addIntChangedListener {
            viewModel.setPriceInches(it)
        }
        binding.btnCalculate.setOnClickListener {
            showPrice(viewModel.calculatePrice())
        }
    }
}