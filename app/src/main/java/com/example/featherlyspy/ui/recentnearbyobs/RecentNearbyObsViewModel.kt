package com.example.featherlyspy.ui.recentnearbyobs

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.featherlyspy.basemvi.BaseViewModel
import com.example.featherlyspy.domain.recentnearbyobs.GetRecentNearbyObsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecentNearbyObsViewModel @Inject constructor(
    private val getRecentNearbyObsUseCase: GetRecentNearbyObsUseCase
) :
    BaseViewModel<RecentNearbyObsState, RecentNearbyObsAction>(
        initialState = RecentNearbyObsState()
    ) {

    override fun reduce(oldState: RecentNearbyObsState, action: RecentNearbyObsAction) {
        viewModelScope.launch {
            when (action) {
                RecentNearbyObsAction.ViewCreated -> {
                    setState(oldState.copy(isLoading = true))
                    val result = getRecentNearbyObsUseCase(
                        lat = 54.38645494829912,
                        lng = 18.569840002964966
                    )

                    if (result.isOk) {
                        setState(
                            oldState.copy(
                                isLoading = false,
                                result.value
                            )
                        )
                    }
//                        .fold(
//                        { success ->
//                            setState(
//                                oldState.copy(
//                                    isLoading = false,
//                                    recentNearbyObsItems = success
//                                )
//                            )
//                        },
//                        { error -> }
//                    )
                }
            }
        }
    }
}
