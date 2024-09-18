package com.example.featherlyspy.config

import javax.inject.Inject

class AppHeaderProvider @Inject constructor(
    private val apiKeyProvider: ApiKeyProvider
) : HeaderProvider {
    override val eBirdApiKey: String
        get() = apiKeyProvider.eBirdApiKey
    override val nuthatchApikey: String
        get() = apiKeyProvider.nuthatchApiKey
}
