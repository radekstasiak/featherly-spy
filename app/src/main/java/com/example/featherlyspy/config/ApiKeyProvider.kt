package com.example.featherlyspy.config

import com.example.featherlyspy.BuildConfig
import javax.inject.Inject

class ApiKeyProvider @Inject constructor() {

    val eBirdApiKey = if (BuildConfig.DEBUG) {
        BuildConfig.EBIRD_API_KEY
    } else {
        ""
    }

    val nuthatchApiKey = if (BuildConfig.DEBUG) {
        BuildConfig.NUTHATCH_API_KEY
    } else {
        ""
    }
}
