package com.example.featherlyspy

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.featherlyspy.ui.recentnearbyobs.RecentNearbyObsActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Rule
import org.junit.Test

//https://medium.com/pulselive/espresso-testing-with-hilt-and-mockwebserver-82f7bcf5a525
@UninstallModules
@HiltAndroidTest
class RecentNearbyObservationsTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    val composeTestRule = createAndroidComposeRule<RecentNearbyObsActivity>()

    @Test
    fun `test_recent_nearby_obs_loads_list_when_started`() {

//        composeTestRule.onn

    }
}
