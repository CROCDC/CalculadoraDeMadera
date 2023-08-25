package com.cr.o.cdc.woodencalculator.ui

import android.view.View
import android.widget.TextView
import androidx.core.view.isVisible
import com.com.cr.o.cdc.woodencalculator.R
import com.cr.o.cdc.woodencalculator.analitycs.Events
import com.cr.o.cdc.woodencalculator.analitycs.MyFirebaseAnalyticsImp
import com.cr.o.cdc.woodencalculator.mocks.MockMyFirebaseAnalyticsImp
import com.cr.o.cdc.woodencalculator.toEditable
import com.google.android.material.textfield.TextInputEditText
import io.mockk.every
import io.mockk.mockkObject
import junit.framework.TestCase.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows

@RunWith(RobolectricTestRunner::class)
class RectanglePriceActivityTest {

    val controller = Robolectric.buildActivity(RectanglePriceActivity::class.java)

    lateinit var inputInchesWidth: TextInputEditText
    lateinit var inputInchesLarge: TextInputEditText
    lateinit var inputInchesThickness: TextInputEditText
    lateinit var inputPriceWood: TextInputEditText
    lateinit var btnCalculate: View
    lateinit var txtPrice: TextView

    @Before
    fun before() {
        mockkObject(MyFirebaseAnalyticsImp)
        every { MyFirebaseAnalyticsImp.create(any()) } returns MockMyFirebaseAnalyticsImp()
        controller.setup()
        val activity = controller.get()
        inputInchesWidth = activity.findViewById(R.id.input_inches_width)
        inputInchesLarge = activity.findViewById(R.id.input_inches_large)
        inputInchesThickness = activity.findViewById(R.id.input_inches_thickness)
        inputPriceWood = activity.findViewById(R.id.input_price_wood)
        btnCalculate = activity.findViewById(R.id.btn_calculate)
        txtPrice = activity.findViewById(R.id.txt_price)
    }

    @Test
    fun calculateWithAllParameters() {
        inputInchesWidth.text = "40".toEditable()
        inputInchesLarge.text = "40".toEditable()
        inputInchesThickness.text = "40".toEditable()
        inputPriceWood.text = "40".toEditable()
        btnCalculate.performClick()
        assert(txtPrice.isVisible)
        assert(Shadows.shadowOf(RuntimeEnvironment.getApplication()).shownToasts.isEmpty())
        assert(MockMyFirebaseAnalyticsImp.events.contains(Events.CALCULATE_PRICE))
        assert(!MockMyFirebaseAnalyticsImp.events.contains(Events.CALCULATE_ERROR))
    }

    @Test
    fun calculateWithoutAllParameters() {
        inputInchesWidth.text = "40".toEditable()
        inputInchesLarge.text = "40".toEditable()
        inputInchesThickness.text = "40".toEditable()
        btnCalculate.performClick()
        assert(txtPrice.isVisible)
        assertEquals(txtPrice.context.getString(R.string.price_calculate_fail), txtPrice.text)
        assert(Shadows.shadowOf(RuntimeEnvironment.getApplication()).shownToasts.isEmpty())
        assert(!MockMyFirebaseAnalyticsImp.events.contains(Events.CALCULATE_PRICE))
        assert(MockMyFirebaseAnalyticsImp.events.contains(Events.CALCULATE_ERROR))
    }

    @Test
    fun calculateWithoutParameters() {
        btnCalculate.performClick()
        assert(txtPrice.isVisible)
        assertEquals(txtPrice.context.getString(R.string.price_calculate_fail), txtPrice.text)
        assert(Shadows.shadowOf(RuntimeEnvironment.getApplication()).shownToasts.isEmpty())
        assert(!MockMyFirebaseAnalyticsImp.events.contains(Events.CALCULATE_PRICE))
        assert(MockMyFirebaseAnalyticsImp.events.contains(Events.CALCULATE_ERROR))
    }

    @Test
    fun showToastInputInchesWidth() {
        inputInchesWidth.text = "esto no es un numero".toEditable()
        assert(Shadows.shadowOf(RuntimeEnvironment.getApplication()).shownToasts.isNotEmpty())
    }

    @After
    fun after() {
        MockMyFirebaseAnalyticsImp.clean()
    }
}