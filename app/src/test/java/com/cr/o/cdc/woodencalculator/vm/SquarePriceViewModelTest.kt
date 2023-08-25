package com.cr.o.cdc.woodencalculator.vm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.cr.o.cdc.woodencalculator.vm.SquarePriceViewModel
import com.cr.o.cdc.woodencalculator.vm.usecases.SquareDelegateImpl
import junit.framework.TestCase.assertEquals
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class SquarePriceViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val viewModel = SquarePriceViewModel(SquareDelegateImpl())

    @Test
    fun case1() {
        viewModel.setInchesWidth(12)
        viewModel.setInchesThickness(3)
        viewModel.setPriceInches(1500)
        assertEquals(4499.95427990856, viewModel.calculatePrice()?.price)
    }

    @Test
    fun case2() {
        viewModel.setInchesWidth(10)
        viewModel.setInchesThickness(5)
        viewModel.setPriceInches(1500)
        assertEquals(5208.280416560833, viewModel.calculatePrice()?.price)
    }

    @Test
    fun case3() {
        viewModel.setPriceInches(200)
        viewModel.setInchesWidth(12)
        viewModel.setInchesThickness(40)
        Assert.assertEquals(7999.91871983744, viewModel.calculatePrice()?.price)
    }
}