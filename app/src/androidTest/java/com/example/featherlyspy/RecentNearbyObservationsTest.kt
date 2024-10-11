package com.example.featherlyspy

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performScrollToNode
import com.example.featherlyspy.ui.ComposableTestTag.RECENT_NEARBY_OBS_LIST_TAG
import com.example.featherlyspy.ui.recentnearbyobs.RecentNearbyObsActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain

@HiltAndroidTest
class RecentNearbyObservationsTest {

    private val hiltRule = HiltAndroidRule(this)
    private val mockWebServerRule = MockWebServerRule()
    private val composeTestRule = createAndroidComposeRule<RecentNearbyObsActivity>()

    @get:Rule
    internal val testRule: RuleChain = RuleChain
        .outerRule(hiltRule)
        .around(mockWebServerRule)
        .around(composeTestRule)

    @Test
    fun `test_recent_nearby_obs_loads_list_when_started`() {
        composeTestRule.onNodeWithTag(RECENT_NEARBY_OBS_LIST_TAG)
            .performScrollToNode(hasText("Goldcrest"))
            .assertIsDisplayed()

    }


}
