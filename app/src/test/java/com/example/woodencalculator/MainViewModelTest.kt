package com.example.woodencalculator

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import junit.framework.TestCase.assertEquals
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val viewModel = MainViewModel()

    @Test
    fun case1() {
        viewModel.setInchesWidth(12)
        viewModel.setInchesThickness(3)
        viewModel.setPriceInches(1500)
        assertEquals(4499, viewModel.calculatePrice())
    }

    @Test
    fun case2() {
        viewModel.setInchesWidth(10)
        viewModel.setInchesThickness(5)
        viewModel.setPriceInches(1500)
        assertEquals(5208, viewModel.calculatePrice())
    }
}