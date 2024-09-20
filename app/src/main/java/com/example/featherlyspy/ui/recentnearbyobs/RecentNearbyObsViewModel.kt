package com.example.featherlyspy.ui.recentnearbyobs

import com.example.featherlyspy.basemvi.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecentNearbyObsViewModel @Inject constructor() :
    BaseViewModel<RecentNearbyObsState, RecentNearbyObsAction>(
        initialState = RecentNearbyObsState()
    ) {

    override fun reduce(oldState: RecentNearbyObsState, action: RecentNearbyObsAction) {
        when (action) {
            RecentNearbyObsAction.ViewCreated -> TODO()
        }
    }

}
