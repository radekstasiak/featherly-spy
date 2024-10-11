package com.example.featherlyspy.network.endpoint

import android.content.Context
import com.example.featherlyspy.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ApiEndpointProviderImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : ApiEndpointProvider {

    override val eBirdApiEndpoint: String
        get() = context.resources.getString(R.string.ebird_api_endpoint)

    override val nuthatchEndpoint
        get() = context.resources.getString(R.string.nuthatch_api_endpoint)
}
