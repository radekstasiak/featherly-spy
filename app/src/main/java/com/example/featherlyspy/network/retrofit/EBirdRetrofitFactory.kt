package com.example.featherlyspy.network.retrofit

import com.example.featherlyspy.network.api.EBirdApiService
import okhttp3.OkHttpClient
import javax.inject.Inject

class EBirdRetrofitFactory @Inject constructor(
    apiEndpoint: String,
    okHttpClient: OkHttpClient
) : BaseRetrofitFactory(
    apiEndpoint,
    okHttpClient
) {

    val service: EBirdApiService =
        retrofitInstance.create(EBirdApiService::class.java)
}
