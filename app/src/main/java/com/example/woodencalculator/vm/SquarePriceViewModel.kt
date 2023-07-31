package com.example.woodencalculator.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.woodencalculator.vm.usecases.SquareUseCase

class SquarePriceViewModel : ViewModel(), SquareUseCase {

    override val inchesThickness: MutableLiveData<Int> = MutableLiveData<Int>()

    override val inchesWidth: MutableLiveData<Int> = MutableLiveData<Int>()

    override val priceInches: MutableLiveData<Int> = MutableLiveData<Int>()
}
