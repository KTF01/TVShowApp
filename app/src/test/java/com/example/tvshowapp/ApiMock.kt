package com.example.tvshowapp

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.io.IOException
import java.nio.charset.StandardCharsets

@RunWith(JUnit4::class)
abstract class ApiMock {
    lateinit var mockWebserver: MockWebServer

    @Throws(IOException::class)
    @Before
    fun prepare(){
        mockWebserver = MockWebServer()
        mockWebserver.start()
    }

    @Throws(IOException::class)
    @After
    fun stopServer() {
        mockWebserver.shutdown()
    }

    @Throws(IOException::class)
    private fun enqueueResponse(headers: Map<String, String>) {
        val mockResponse = MockResponse()
        for ((key, value) in headers) {
            mockResponse.addHeader(key, value)
        }
        mockWebserver.enqueue(mockResponse.setBody(ResponseMock.testResponse))
    }
}