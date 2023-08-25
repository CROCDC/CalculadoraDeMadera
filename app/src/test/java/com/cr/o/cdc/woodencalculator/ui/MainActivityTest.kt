package com.cr.o.cdc.woodencalculator.ui

import android.content.Intent
import android.view.View
import com.com.cr.o.cdc.woodencalculator.R
import com.cr.o.cdc.woodencalculator.analitycs.Events
import com.cr.o.cdc.woodencalculator.analitycs.MyFirebaseAnalyticsImp
import com.cr.o.cdc.woodencalculator.mocks.MockMyFirebaseAnalyticsImp
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
import org.robolectric.Shadows.shadowOf

@RunWith(RobolectricTestRunner::class)
class MainActivityTest {

    private val controller = Robolectric.buildActivity(MainActivity::class.java)
    private lateinit var activity: MainActivity

    @Before
    fun before() {
        mockkObject(MyFirebaseAnalyticsImp.Companion)
        every { MyFirebaseAnalyticsImp.Companion.create(any()) } returns MockMyFirebaseAnalyticsImp()
        controller.setup()
        activity = controller.get()
    }

    @Test
    fun navigateToRectanglePriceActivity() {
        activity.findViewById<View>(R.id.btn_rectangle).performClick()
        val expectedIntent = Intent(activity, RectanglePriceActivity::class.java)
        val actual: Intent = shadowOf(RuntimeEnvironment.getApplication()).nextStartedActivity
        assertEquals(expectedIntent.component, actual.component)
        assert(MockMyFirebaseAnalyticsImp.events.contains(Events.GO_TO_RECTANGLE))

    }

    @Test
    fun navigateToSquarePriceActivity() {
        activity.findViewById<View>(R.id.btn_square).performClick()
        val expectedIntent = Intent(activity, SquarePriceActivity::class.java)
        val actual: Intent = shadowOf(RuntimeEnvironment.getApplication()).nextStartedActivity
        assertEquals(expectedIntent.component, actual.component)
        assert(MockMyFirebaseAnalyticsImp.events.contains(Events.GO_TO_SQUARE))
    }

    @After
    fun after() {
        MockMyFirebaseAnalyticsImp.clean()
    }
}