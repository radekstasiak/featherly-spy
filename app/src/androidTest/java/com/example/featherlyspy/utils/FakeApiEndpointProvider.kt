package com.example.featherlyspy.utils

import com.example.featherlyspy.network.endpoint.ApiEndpointProvider
import com.example.featherlyspy.utils.Constants.MOCK_WEBSERVER_URL
import javax.inject.Inject

class FakeApiEndpointProvider @Inject constructor() : ApiEndpointProvider {


    override val eBirdApiEndpoint: String
        get() = MOCK_WEBSERVER_URL
    override val nuthatchEndpoint: String
        get() = MOCK_WEBSERVER_URL
}
