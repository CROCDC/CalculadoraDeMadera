package com.example.woodencalculator.vm.usecases

import androidx.lifecycle.MutableLiveData
import com.example.woodencalculator.utils.setValueIfNotNull

interface RectanglePriceDelegate : InchesDelegate {

    val inchesLarge: MutableLiveData<Int>

    fun setInchesLarge(inchesLarge: Int?)
}

class RectanglePriceDelegateImpl : RectanglePriceDelegate {
    override val inchesThickness: MutableLiveData<Int> = MutableLiveData()
    override val inchesWidth: MutableLiveData<Int> = MutableLiveData()
    override val priceInches: MutableLiveData<Int> = MutableLiveData()
    override val inchesLarge: MutableLiveData<Int> = MutableLiveData()

    override fun setInchesLarge(inchesLarge: Int?) {
        this.inchesLarge.setValueIfNotNull(inchesLarge)
    }

    override fun calculatePrice(): Result? {
        val inchesThicknessValue = inchesThickness.value
        val inchesWidthValue = inchesWidth.value
        val inchesLargeValue = inchesLarge.value
        val priceInchesValue = priceInches.value
        return if (inchesThicknessValue != null && inchesWidthValue != null
            && priceInchesValue != null && inchesLargeValue != null
        ) {
            val pie2 = (inchesThicknessValue * inchesWidthValue * inchesLargeValue) / 144.0
            pie2 * priceInchesValue
            Result((pie2 * priceInchesValue), pie2.toInt())
        } else {
            null
        }
    }
}
