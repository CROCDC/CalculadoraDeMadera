package com.cr.o.cdc.woodencalculator.analitycs

import android.content.Context
import androidx.core.os.bundleOf
import com.google.firebase.analytics.FirebaseAnalytics

interface MyFirebaseAnalytics {
    fun trackEvent(name: String)

    fun trackPrice(name: String, price: Double)
}

class MyFirebaseAnalyticsImp(context: Context) : MyFirebaseAnalytics {
    private val firebase = FirebaseAnalytics.getInstance(context)
    override fun trackEvent(name: String) {
        firebase.logEvent(name, null)
    }

    override fun trackPrice(name: String, price: Double) {
        firebase.logEvent(name, bundleOf("price" to price))
    }

    companion object {
        fun create(context: Context): MyFirebaseAnalytics = MyFirebaseAnalyticsImp(context)
    }
}