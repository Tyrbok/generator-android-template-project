package com.bitban.bnsstats.application

import android.support.test.InstrumentationRegistry
import android.support.test.rule.ActivityTestRule
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import io.reactivex.Single
import it.cosenonjaviste.daggermock.DaggerMockRule
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import <%= packageName %>.application.MainActivity
import <%= packageName %>.domain.StarterData
import <%= packageName %>.domain.StarterDataRepository
import <%= packageName %>.support.Bootstrap
import <%= packageName %>.support.di.AppComponent
import <%= packageName %>.support.di.AppModule

class MainActivityTest {

    private val starterDataRepository: StarterDataRepository = mock(StarterDataRepository::class.java)

    private fun getApp(): Bootstrap {
        return InstrumentationRegistry.getInstrumentation().targetContext
                .applicationContext as Bootstrap
    }

    @get:Rule
    var activityRule = ActivityTestRule(
            MainActivity::class.java,
            false,
            false
    )

    @Rule
    @JvmField
    var daggerRule: DaggerMockRule<AppComponent> =
            DaggerMockRule(AppComponent::class.java, AppModule(getApp()))
                    .set({ component -> getApp().component = component })

    @Test
    fun should_display_message() {
        `when`(starterDataRepository.get()).thenReturn(Single.just(StarterData("Hello Mocked Value")))
        activityRule.launchActivity(null)
        assertDisplayed("Hello Mocked Value")
    }
}