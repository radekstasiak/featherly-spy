package com.example.featherlyspy

import com.example.featherlyspy.utils.Constants.MOCK_WEBSERVER_PORT
import com.example.featherlyspy.utils.JsonFileUtils.getJsonContent
import com.example.featherlyspy.utils.MockResponseFactory
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class MockWebServerRule : TestRule {

    private val mockWebServer = MockWebServer()

    private val mockResponseFactory by lazy {
        MockResponseFactory()
    }

    override fun apply(base: Statement?, description: Description?): Statement =
        object : Statement() {
            override fun evaluate() {
                mockWebServer.start(MOCK_WEBSERVER_PORT)
                mockWebServer.dispatcher = object : Dispatcher() {
                    override fun dispatch(request: RecordedRequest): MockResponse =
                        mockResponseFactory.create(request)
                }
                try {
                    base?.evaluate()
                } finally {
                    mockWebServer.shutdown()
                }
            }

        }
}
