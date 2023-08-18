package com.example.woodencalculator

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.woodencalculator.vm.RectanglePriceViewModel
import com.example.woodencalculator.vm.usecases.RectanglePriceDelegateImpl
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class RectanglePriceViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val viewModel = RectanglePriceViewModel(RectanglePriceDelegateImpl())

    @Test
    fun case1() {
        viewModel.setPriceInches(80)
        viewModel.setInchesWidth(12)
        viewModel.setInchesLarge(12)
        viewModel.setInchesThickness(1)
        assertEquals(80.0, viewModel.calculatePrice()?.price)
    }
}