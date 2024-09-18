package com.example.featherlyspy.network.okhttp.interceptor

import com.example.featherlyspy.config.ApiHeaders
import com.example.featherlyspy.config.HeaderProvider
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class EBirdHttpClientInterceptor @Inject constructor(
    private val headerProvider: HeaderProvider
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response = chain.let {
        it.proceed(
            it.request().newBuilder().apply {
                addHeader(ApiHeaders.X_EBIRDAPITOKEN, headerProvider.eBirdApiKey)
            }.build()
        )
    }
}
