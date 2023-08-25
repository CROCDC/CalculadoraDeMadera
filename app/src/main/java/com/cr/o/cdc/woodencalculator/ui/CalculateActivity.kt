package com.cr.o.cdc.woodencalculator.ui

import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.com.cr.o.cdc.woodencalculator.R
import com.cr.o.cdc.woodencalculator.analitycs.Events
import com.cr.o.cdc.woodencalculator.analitycs.MyFirebaseAnalyticsImp
import com.cr.o.cdc.woodencalculator.utils.toInt
import com.cr.o.cdc.woodencalculator.vm.usecases.Result
import com.google.android.material.textfield.TextInputEditText

abstract class CalculateActivity : AppCompatActivity() {
    abstract val txtPrice: TextView

    @Suppress("LeakingThis")
    private val analytics = MyFirebaseAnalyticsImp.create(this)
    fun TextInputEditText.addIntChangedListener(setOnChange: (Int?) -> Unit) {
        this.addTextChangedListener {
            try {
                setOnChange.invoke(it.toInt())
            } catch (e: Exception) {
                Toast.makeText(this@CalculateActivity, R.string.number_warning, Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    fun showPrice(result: Result?) {
        if (result?.price != null) {
            analytics.trackPrice(Events.CALCULATE_PRICE, result.price)
            txtPrice.text = getString(R.string.price_this, result.price)
        } else {
            analytics.trackEvent(Events.CALCULATE_ERROR)
            txtPrice.setText(R.string.price_calculate_fail)
        }
    }
}