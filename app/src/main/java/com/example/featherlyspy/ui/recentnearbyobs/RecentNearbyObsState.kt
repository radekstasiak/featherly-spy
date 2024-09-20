package com.example.featherlyspy.ui.recentnearbyobs

import com.example.featherlyspy.basemvi.MviState

data class RecentNearbyObsState(
    val isLoading: Boolean = false
) : MviState
