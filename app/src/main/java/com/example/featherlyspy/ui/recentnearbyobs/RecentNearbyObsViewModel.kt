package com.example.featherlyspy.ui.recentnearbyobs

import com.example.featherlyspy.basemvi.BaseViewModel
import com.example.featherlyspy.domain.recentnearbyobs.GetRecentNearbyObsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecentNearbyObsViewModel @Inject constructor(
    private val getRecentNearbyObsUseCase: GetRecentNearbyObsUseCase
) :
    BaseViewModel<RecentNearbyObsState, RecentNearbyObsAction>(
        initialState = RecentNearbyObsState()
    ) {

    override fun reduce(oldState: RecentNearbyObsState, action: RecentNearbyObsAction) {
        when (action) {
            RecentNearbyObsAction.ViewCreated -> setState(oldState.copy(isLoading = true))

        }
    }

}
