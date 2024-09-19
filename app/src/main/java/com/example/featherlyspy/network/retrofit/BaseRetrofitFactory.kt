package com.example.featherlyspy.network.retrofit

import com.haroldadmin.cnradapter.NetworkResponseAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

open class BaseRetrofitFactory(
    apiEndpoint: String,
    client: OkHttpClient
) {

    val retrofitInstance: Retrofit = Retrofit.Builder()
        .baseUrl(apiEndpoint)
        .addCallAdapterFactory(NetworkResponseAdapterFactory())
        .addConverterFactory(MoshiConverterFactory.create())
        .client(client)
        .build()
}
