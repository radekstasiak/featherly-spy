package com.example.featherlyspy.network.okhttp

import com.example.featherlyspy.network.okhttp.interceptor.EBirdHttpClientInterceptor
import okhttp3.OkHttpClient
import javax.inject.Inject

class OkHttpClientFactory @Inject constructor(
    eBirdHttpClientInterceptor: EBirdHttpClientInterceptor
) {

    val eBirdOkHttpClient: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(eBirdHttpClientInterceptor)
        .build()

}
