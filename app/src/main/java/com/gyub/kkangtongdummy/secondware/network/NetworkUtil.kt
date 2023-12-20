package com.gyub.kkangtongdummy.secondware.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import okhttp3.Interceptor
import java.util.Locale

object NetworkUtil {
    fun getPrettyLogs(text: String?): String {
        text ?: return ""

        return try {
            val jsonElement = JsonParser().parse(text)

            val gson: Gson = GsonBuilder().setPrettyPrinting().create()
            gson.toJson(jsonElement)
        } catch (e: Throwable) {
            text
        }
    }

    /**
     * 헤더 세팅
     *
     * @return
     */
    fun createHeader() =
        Interceptor { chain: Interceptor.Chain ->
            val original = chain.request()
            val builder = original.newBuilder().apply {
                getHeaders().forEach { (key, value) -> header(key, value) }

                if ("POST" == original.method || "PUT" == original.method) {
                    header("content-type", "application/x-www-form-urlencoded")
                }
                original.headers["Accept-Encoding"]?.let {
                    header("content-type", "application/json")
                }
            }
            chain.proceed(builder.build())
        }

    private fun getHeaders(): Map<String, String> {
        return mapOf(
            "Accept-Language" to Locale.getDefault().language,
            "Accept" to "application/json",
        )
    }
}