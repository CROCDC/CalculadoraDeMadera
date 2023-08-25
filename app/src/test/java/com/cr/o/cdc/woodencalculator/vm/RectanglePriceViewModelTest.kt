package com.cr.o.cdc.woodencalculator.vm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.cr.o.cdc.woodencalculator.vm.usecases.RectanglePriceDelegateImpl
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

    @Test
    fun case2() {
        viewModel.setPriceInches(200)
        viewModel.setInchesLarge(12)
        viewModel.setInchesWidth(12)
        viewModel.setInchesThickness(40)
        assertEquals(8000.0, viewModel.calculatePrice()?.price)
    }
}