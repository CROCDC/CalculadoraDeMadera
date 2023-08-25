package com.cr.o.cdc.woodencalculator.mocks

import com.cr.o.cdc.woodencalculator.analitycs.MyFirebaseAnalytics

class MockMyFirebaseAnalyticsImp : MyFirebaseAnalytics {

    override fun trackEvent(name: String) {
        events.add(name)
    }

    override fun trackPrice(name: String, price: Double) {
        events.add(name)
    }

    companion object {
        val events: MutableList<String> = mutableListOf()

        fun clean() {
            events.clear()
        }
    }
}