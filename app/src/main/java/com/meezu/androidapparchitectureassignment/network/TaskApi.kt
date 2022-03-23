package com.meezu.androidapparchitectureassignment.network

import com.meezu.androidapparchitectureassignment.features.shared.model.response.AddTaskResponse
import com.meezu.androidapparchitectureassignment.features.shared.model.response.TaskResponse
import com.meezu.androidapparchitectureassignment.utils.constants.ApiConstants
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface TaskApi {

    @POST(ApiConstants.addTask)
    fun addTask(): Single<Response<AddTaskResponse>>

    @GET(ApiConstants.getTasks)
    fun getAllTasks(): Single<Response<ArrayList<TaskResponse>>>
}