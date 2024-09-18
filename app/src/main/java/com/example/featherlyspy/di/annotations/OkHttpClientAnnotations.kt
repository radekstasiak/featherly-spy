package com.example.featherlyspy.di.annotations

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class EBirdOkHttpClient

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class NuthatchOkHttpClient
