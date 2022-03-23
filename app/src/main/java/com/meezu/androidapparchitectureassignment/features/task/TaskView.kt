package com.meezu.androidapparchitectureassignment.features.task

import com.hannesdorfmann.mosby3.mvp.MvpView
import com.meezu.androidapparchitectureassignment.features.shared.model.response.TaskResponse

interface TaskView: MvpView {

    fun setTasks(tasksList: ArrayList<TaskResponse>)
    fun showErrorMessage(localizedMessage: String?)
}