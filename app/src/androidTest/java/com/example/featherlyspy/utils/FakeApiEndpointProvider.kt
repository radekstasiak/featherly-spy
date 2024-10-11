package com.example.featherlyspy.utils

import com.example.featherlyspy.network.endpoint.ApiEndpointProvider

class FakeApiEndpointProvider : ApiEndpointProvider {

    private val MOCK_WEBSERVER_URL = "http://127.0.0.1:8080"

    override val eBirdApiEndpoint: String
        get() = MOCK_WEBSERVER_URL
    override val nuthatchEndpoint: String
        get() = MOCK_WEBSERVER_URL
}
