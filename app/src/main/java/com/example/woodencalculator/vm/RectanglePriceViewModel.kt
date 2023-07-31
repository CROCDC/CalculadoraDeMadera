package com.example.woodencalculator.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.woodencalculator.vm.usecases.RectanglePriceUseCase

class RectanglePriceViewModel : ViewModel(), RectanglePriceUseCase {

    override val inchesLarge: MutableLiveData<Int> = MutableLiveData()
    override val inchesThickness: MutableLiveData<Int> = MutableLiveData()
    override val inchesWidth: MutableLiveData<Int> = MutableLiveData()
    override val priceInches: MutableLiveData<Int> = MutableLiveData()
}