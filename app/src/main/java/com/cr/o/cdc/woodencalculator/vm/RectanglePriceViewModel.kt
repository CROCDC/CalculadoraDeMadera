package com.cr.o.cdc.woodencalculator.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.cr.o.cdc.woodencalculator.vm.usecases.RectanglePriceDelegate
import com.cr.o.cdc.woodencalculator.vm.usecases.RectanglePriceDelegateImpl

open class RectanglePriceViewModel(delegate: RectanglePriceDelegateImpl) : ViewModel(),
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