package com.example.featherlyspy.utils

import java.io.InputStreamReader

object JsonFileUtils {

    fun getJsonContent(fileName: String): String {
        return InputStreamReader(this.javaClass.classLoader!!.getResourceAsStream(fileName))
            .use { it.readText() }
    }

}
