package com.example.woodencalculator.vm.usecases

import androidx.lifecycle.MutableLiveData
import com.example.woodencalculator.utils.setValueIfNotNull

interface XInchesUseCase {

    val inchesThickness: MutableLiveData<Int>

    val inchesWidth: MutableLiveData<Int>

    val priceInches: MutableLiveData<Int>

    fun calculatePrice(): Int?

    fun setInchesThickness(inchesThickness: Int?) {
        this.inchesThickness.setValueIfNotNull(inchesThickness)
    }

    fun setInchesWidth(inchesWidth: Int?) {
        this.inchesWidth.setValueIfNotNull(inchesWidth)
    }

    fun setPriceInches(priceInches: Int?) {
        this.priceInches.setValueIfNotNull(priceInches)
    }
}