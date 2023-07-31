package com.example.woodencalculator.vm.usecases

import androidx.lifecycle.MutableLiveData
import com.example.woodencalculator.utils.setValueIfNotNull

interface RectanglePriceUseCase : XInchesUseCase {
    val inchesLarge: MutableLiveData<Int>

    fun setInchesLarge(inchesLarge: Int?) {
        this.inchesLarge.setValueIfNotNull(inchesLarge)
    }

    override fun calculatePrice(): Int? {
        val inchesThicknessValue = inchesThickness.value
        val inchesWidthValue = inchesWidth.value
        val inchesLargeValue = inchesLarge.value
        val priceInchesValue = priceInches.value
        return if (inchesThicknessValue != null && inchesWidthValue != null
            && priceInchesValue != null && inchesLargeValue != null
        ) {
            val pie2 = (inchesThicknessValue * inchesWidthValue * inchesLargeValue) / 144
            pie2 * priceInchesValue
        } else {
            null
        }?.toInt()
    }
}

