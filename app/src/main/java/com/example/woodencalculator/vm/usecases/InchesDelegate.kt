package com.example.woodencalculator.vm.usecases

import androidx.lifecycle.MutableLiveData
import com.example.woodencalculator.utils.setValueIfNotNull

interface InchesDelegate {
    val inchesThickness: MutableLiveData<Int>

    val inchesWidth: MutableLiveData<Int>

    val priceInches: MutableLiveData<Int>

    fun calculatePrice(): Result?

    fun setInchesThickness(inchesThicknesss: Int?) {
        inchesThickness.setValueIfNotNull(inchesThicknesss)
    }

    fun setInchesWidth(inchesWidthh: Int?) {
        inchesWidth.setValueIfNotNull(inchesWidthh)
    }

    fun setPriceInches(priceInchess: Int?) {
        priceInches.setValueIfNotNull(priceInchess)
    }
}

