package com.cr.o.cdc.woodencalculator.vm.usecases

import androidx.lifecycle.MutableLiveData

interface SquareDelegate : InchesDelegate

class SquareDelegateImpl : SquareDelegate {

    override val inchesThickness: MutableLiveData<Int> = MutableLiveData()
    override val inchesWidth: MutableLiveData<Int> = MutableLiveData()
    override val priceInches: MutableLiveData<Int> = MutableLiveData()

    override fun calculatePrice(): Result? {
        val inchesThicknessValue = inchesThickness.value
        val inchesWidthValue = inchesWidth.value

        val priceInchesValue = priceInches.value
        return if (inchesThicknessValue != null && inchesWidthValue != null && priceInchesValue != null) {
            val volume = inchesThicknessValue * inchesWidthValue * CONST_RADIO
            val volumeMeter = volume * (inchesWidthValue / INCHES_TO_METERS)
            volumeMeter * priceInchesValue
            Result((volumeMeter * priceInchesValue), 0)
        } else {
            null
        }
    }

    companion object {
        const val INCHES_TO_METERS = 39.37
        const val CONST_RADIO = 0.2734
    }
}