package com.example.featherlyspy.di.annotations

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ApiEBirdEndpoint

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ApiNuthatchEndpoint
