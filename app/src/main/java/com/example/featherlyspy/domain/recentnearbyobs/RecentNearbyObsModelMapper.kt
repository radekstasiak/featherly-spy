package com.example.featherlyspy.domain.recentnearbyobs

import com.example.featherlyspy.domain.base.DomainMapper
import com.example.featherlyspy.network.model.RecentNearbyObsApiModel
import javax.inject.Inject

class RecentNearbyObsModelMapper @Inject constructor() :
    DomainMapper<List<RecentNearbyObsApiModel>, List<RecentNearbyObsModel>> {

    override fun toDomain(input: List<RecentNearbyObsApiModel>): List<RecentNearbyObsModel> =
        input.map {
            RecentNearbyObsModel(
                comName = it.comName,
                sciName = it.sciName,
                locId = it.locId,
                obsDate = it.obsDt
            )
        }

}
