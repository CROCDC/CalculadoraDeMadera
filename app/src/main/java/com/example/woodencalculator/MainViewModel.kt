package com.example.woodencalculator

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val inchesThickness: MutableLiveData<Int> = MutableLiveData<Int>()

    private val inchesWidth: MutableLiveData<Int> = MutableLiveData<Int>()

    private val priceInches: MutableLiveData<Int> = MutableLiveData<Int>()

    fun calculatePrice(): Int? {
        val inchesThicknessValue = inchesThickness.value
        val inchesWidthValue = inchesWidth.value

        val priceInchesValue = priceInches.value
        return if (inchesThicknessValue != null && inchesWidthValue != null && priceInchesValue != null) {
            val volume = inchesThicknessValue * inchesWidthValue * CONST_RADIO
            val volumeMeter = volume * (inchesWidthValue / INCHES_TO_METERS)
            volumeMeter * priceInchesValue
        } else {
            null
        }?.toInt()
    }

    fun setInchesThickness(inchesThickness: Int?) {
        if (inchesThickness != null) {
            this.inchesThickness.value = inchesThickness
        }
    }

    fun setInchesWidth(inchesWidth: Int?) {
        if (inchesWidth != null) {
            this.inchesWidth.value = inchesWidth
        }
    }

    fun setPriceInches(priceInches: Int?) {
        if (priceInches != null) {
            this.priceInches.value = priceInches
        }
    }

    companion object {
        const val INCHES_TO_METERS = 39.37
        const val CONST_RADIO = 0.2734
    }
}
