package com.meezu.androidapparchitectureassignment.network

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.meezu.androidapparchitectureassignment.utils.constants.ApiConstants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitHelper {

    private var apiInstance: TaskApi? = null
    val gson = GsonBuilder().setLenient().create()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(ApiConstants.baseURl)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(getOkHttpClient())
        .build()

    private fun getOkHttpClient(): OkHttpClient{
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
            .build()
        return okHttpClient
    }

    fun getTaskApi(): TaskApi {
        if (apiInstance == null) {
            apiInstance = retrofit.create(TaskApi::class.java)
        }
        return apiInstance ?: retrofit.create(TaskApi::class.java)
    }

}