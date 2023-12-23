package com.gyub.kkangtongdummy.secondware.network

import android.util.Log
import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import java.util.Locale
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private const val METHOD_POST = "POST"
    const val METHOD_PUT = "PUT"

    /**
     * 공통 헤더 Interceptor
     */
    private val gHeaderInterceptor = Interceptor { chain: Interceptor.Chain ->
        val original = chain.request()
        var request: Request? = null
        try {
            var builder: Request.Builder = original.newBuilder()
                .header(Headers.ACCEPT_LANGUAGE, Locale.getDefault().language)
                .header(Headers.ACCEPT, "application/json")
                .method(original.method, original.body)
            if (original.headers["Accept-Encoding"] != null) {
                builder = builder.header("Content-type", "application/json")
            } else if (METHOD_POST == original.method || METHOD_PUT == original.method) {
                builder = builder.header(Headers.CONTENT_TYPE, "application/x-www-form-urlencoded")
            }
            request = builder.build()
        } catch (e: Exception) {
            Log.e(e.message, e.cause?.message, e.cause)
        }
        chain.proceed(request!!)
    }
    private val gLogging: HttpLoggingInterceptor by lazy { HttpLoggingInterceptor() }
    private var gRetrofitClient: Retrofit? = null

    /**
     * Singleton Retrofit
     *
     * @return
     */
    fun getClient(): Retrofit? {
        if (gRetrofitClient == null) {
            synchronized(RetrofitClient::class.java) {
                if (gRetrofitClient == null) {
                    val okClient = unsafeOkHttpClient
                    val objectMapper = ObjectMapper()
                    objectMapper.setVisibility(objectMapper.visibilityChecker.withFieldVisibility(JsonAutoDetect.Visibility.ANY))
                    objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                    objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
                    val converter = JacksonConverterFactory.create(objectMapper)
                    gRetrofitClient = Retrofit.Builder()
                        .baseUrl(ApiInfo.BASE_URL)
                        .client(okClient)
                        .addConverterFactory(converter)
                        .build()
                }
            }
        }
        return gRetrofitClient
    }

    private val unsafeOkHttpClient: OkHttpClient
        get() = try {
                OkHttpClient.Builder()
                    .addInterceptor(gHeaderInterceptor)
                    .addInterceptor(gLogging) //                    .addNetworkInterceptor(new StethoInterceptor())
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .build()
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

    /**
     * 헤더 정의
     */
    object Headers {
        const val ACCEPT_LANGUAGE = "Accept-Language"
        const val ACCEPT = "Accept"
        const val CONTENT_TYPE = "content-type"
    }
}