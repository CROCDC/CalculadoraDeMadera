package com.cr.o.cdc.woodencalculator.ui

import android.view.View
import android.widget.TextView
import androidx.core.view.isVisible
import com.com.cr.o.cdc.woodencalculator.R
import com.cr.o.cdc.woodencalculator.analitycs.Events
import com.cr.o.cdc.woodencalculator.mocks.MockMyFirebaseAnalyticsImp
import com.cr.o.cdc.woodencalculator.toEditable
import com.google.android.material.textfield.TextInputEditText
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows.shadowOf

@RunWith(RobolectricTestRunner::class)
class SquarePriceActivityTest {
    private val controller = Robolectric.buildActivity(SquarePriceActivity::class.java)

    private lateinit var inputInchesWidth: TextInputEditText
    private lateinit var inputInchesThickness: TextInputEditText
    private lateinit var inputPriceWood: TextInputEditText
    private lateinit var btnCalculate: View
    private lateinit var txtPrice: TextView

    @Before
    fun before() {
        controller.setup()
        val activity = controller.get()
        inputInchesWidth = activity.findViewById(R.id.input_inches_width)
        inputInchesThickness = activity.findViewById(R.id.input_inches_thickness)
        inputPriceWood = activity.findViewById(R.id.input_price_wood)
        btnCalculate = activity.findViewById(R.id.btn_calculate)
        txtPrice = activity.findViewById(R.id.txt_price)
    }

    @Test
    fun calculateWithAllParameters() {
        inputInchesWidth.text = "40".toEditable()
        inputInchesThickness.text = "40".toEditable()
        inputPriceWood.text = "40".toEditable()
        btnCalculate.performClick()
        assert(txtPrice.isVisible)
        assert(shadowOf(RuntimeEnvironment.getApplication()).shownToasts.isEmpty())
        assert(MockMyFirebaseAnalyticsImp.events.contains(Events.CALCULATE_PRICE))
    }

    @Test
    fun calculateWithoutAllParameters() {
        inputInchesWidth.text = "40".toEditable()
        inputInchesThickness.text = "40".toEditable()
        btnCalculate.performClick()
        assert(txtPrice.isVisible)
        TestCase.assertEquals(
            txtPrice.context.getString(R.string.price_calculate_fail),
            txtPrice.text
        )
        assert(shadowOf(RuntimeEnvironment.getApplication()).shownToasts.isEmpty())
        assert(MockMyFirebaseAnalyticsImp.events.contains(Events.CALCULATE_ERROR))
    }

    @Test
    fun calculateWithoutParameters() {
        btnCalculate.performClick()
        assert(txtPrice.isVisible)
        TestCase.assertEquals(
            txtPrice.context.getString(R.string.price_calculate_fail),
            txtPrice.text
        )
        assert(shadowOf(RuntimeEnvironment.getApplication()).shownToasts.isEmpty())
        assert(MockMyFirebaseAnalyticsImp.events.contains(Events.CALCULATE_ERROR))
    }

    @Test
    fun showToastInputInchesWidth(){
        inputInchesWidth.text = "esto no es un numero".toEditable()
        assert(shadowOf(RuntimeEnvironment.getApplication()).shownToasts.isNotEmpty())
    }

}