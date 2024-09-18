package com.example.featherlyspy.network.endpoint

import android.content.Context
import com.example.featherlyspy.R
import javax.inject.Inject

class ApiEndpointProvider @Inject constructor(
    context: Context
) {

    val eBirdApiEndpoint = context.resources.getString(R.string.ebird_api_endpoint)
    val nuthatchEndpoint = context.resources.getString(R.string.nuthatch_api_endpoint)
}
