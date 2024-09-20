package com.example.featherlyspy.ui.recentnearbyobs

import com.example.featherlyspy.basemvi.MviAction

sealed class RecentNearbyObsAction : MviAction {

    data object ViewCreated : RecentNearbyObsAction()
}
