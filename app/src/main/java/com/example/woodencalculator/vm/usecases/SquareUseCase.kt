package com.example.woodencalculator.vm.usecases

interface SquareUseCase : XInchesUseCase {
    override fun calculatePrice(): Int? {
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

    companion object {
        const val INCHES_TO_METERS = 39.37
        const val CONST_RADIO = 0.2734
    }
}