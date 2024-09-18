package com.example.featherlyspy.network.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit

open class BaseRetrofitFactory(
    apiEndpoint: String,
    client: OkHttpClient
) {

    val retrofitInstance: Retrofit = Retrofit.Builder()
        .baseUrl(apiEndpoint)
        .client(client)
        .build()
}
