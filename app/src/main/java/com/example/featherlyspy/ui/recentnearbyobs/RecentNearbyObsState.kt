package com.example.featherlyspy.ui.recentnearbyobs

import com.example.featherlyspy.basemvi.MviState
import com.example.featherlyspy.domain.recentnearbyobs.RecentNearbyObsModel

data class RecentNearbyObsState(
    val isLoading: Boolean = false,
    val recentNearbyObsItems: List<RecentNearbyObsModel> = listOf()
) : MviState
