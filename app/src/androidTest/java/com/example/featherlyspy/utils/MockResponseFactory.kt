package com.example.featherlyspy.utils

import com.example.featherlyspy.utils.JsonFileUtils.getJsonContent
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import javax.inject.Inject

internal class MockResponseFactory @Inject constructor() {

    fun create(request: RecordedRequest): MockResponse =
        when (request.path) {
            "/v2/data/obs/geo/recent?lat=54.38645494829912&lng=18.569840002964966" -> getRecentNearbyObservations200()
            else -> getGeneric400()
        }

    private fun getRecentNearbyObservations200(): MockResponse =
        MockResponse()
            .setResponseCode(200)
            .setBody(getJsonContent("get_recent_nearby_observations_200.json"))

    private fun getGeneric400(): MockResponse =
        MockResponse()
            .setResponseCode(400)

}
