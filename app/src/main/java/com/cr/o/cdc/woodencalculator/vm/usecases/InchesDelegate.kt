package com.cr.o.cdc.woodencalculator.vm.usecases

import androidx.lifecycle.MutableLiveData
import com.cr.o.cdc.woodencalculator.utils.setValueIfNotNull

interface InchesDelegate {
    val inchesThickness: MutableLiveData<Int>

    val inchesWidth: MutableLiveData<Int>

    val priceInches: MutableLiveData<Int>

    fun calculatePrice(): Result?

    fun setInchesThickness(inchesThicknesss: Int?) {
        inchesThickness.setValueIfNotNull(inchesThicknesss)
    }

    fun setInchesWidth(inchesWidth: Int?) {
        this.inchesWidth.setValueIfNotNull(inchesWidth)
    }

    fun setPriceInches(priceInches: Int?) {
        this.priceInches.setValueIfNotNull(priceInches)
    }
}

