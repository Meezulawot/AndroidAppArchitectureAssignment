package com.meezu.androidapparchitectureassignment.features.shared.repository

import android.annotation.SuppressLint
import com.meezu.androidapparchitectureassignment.features.shared.adapter.TaskAdapter
import com.meezu.androidapparchitectureassignment.features.shared.model.response.AddTaskResponse
import com.meezu.androidapparchitectureassignment.features.shared.model.response.TaskResponse
import com.meezu.androidapparchitectureassignment.network.RetrofitHelper
import com.meezu.androidapparchitectureassignment.utils.constants.StringConstants
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class TaskRepository {

    private val taskApi = RetrofitHelper.getTaskApi()
    private val taskList: ArrayList<TaskResponse>? = null
    private val taskAdapter : TaskAdapter? = null;
    val task: TaskResponse? = null

    @SuppressLint("CheckResult")
    fun getAllTasks(): Single<ArrayList<TaskResponse>> = Single.create { e ->

        taskApi.getAllTasks()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                if (response.isSuccessful) {
                    e.onSuccess(response.body()!!)
                } else {
                    e.onError(Throwable(StringConstants.ApiError))
                }
            }, {
                e.onError(Throwable(it.localizedMessage))
            })
    }

    @SuppressLint("CheckResult")
    fun addTask(): Single<AddTaskResponse> = Single.create { e ->

        taskApi.addTask()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                if (response.isSuccessful) {
                    e.onSuccess(response.body()!!)
                } else {
                    e.onError(Throwable(StringConstants.ApiError))
                }
            }, {
                e.onError(Throwable(it.localizedMessage))

            })
    }
}
