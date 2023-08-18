package com.example.woodencalculator.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.woodencalculator.vm.usecases.RectanglePriceDelegate
import com.example.woodencalculator.vm.usecases.RectanglePriceDelegateImpl

class RectanglePriceViewModel(delegate: RectanglePriceDelegateImpl) : ViewModel(),
    RectanglePriceDelegate by delegate {

    companion object {
        val FACTORY: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                RectanglePriceViewModel(
                    delegate = RectanglePriceDelegateImpl()
                )
            }
        }
    }
}