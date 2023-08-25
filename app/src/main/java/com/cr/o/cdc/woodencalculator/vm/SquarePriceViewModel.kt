package com.cr.o.cdc.woodencalculator.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.cr.o.cdc.woodencalculator.vm.usecases.SquareDelegate
import com.cr.o.cdc.woodencalculator.vm.usecases.SquareDelegateImpl

class SquarePriceViewModel(delegate: SquareDelegateImpl) : ViewModel(), SquareDelegate by delegate {
    companion object {
        val FACTORY: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                SquarePriceViewModel(
                    delegate = SquareDelegateImpl()
                )
            }
        }
    }
}
