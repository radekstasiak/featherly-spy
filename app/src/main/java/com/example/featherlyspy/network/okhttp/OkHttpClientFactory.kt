package com.example.featherlyspy.network.okhttp

import com.example.featherlyspy.network.okhttp.interceptor.EBirdHttpClientInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Inject

class OkHttpClientFactory @Inject constructor(
    eBirdHttpClientInterceptor: EBirdHttpClientInterceptor,
    httpLoggingInterceptor: HttpLoggingInterceptor
) {

    val eBirdOkHttpClient: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .addInterceptor(eBirdHttpClientInterceptor)
        .build()

}
