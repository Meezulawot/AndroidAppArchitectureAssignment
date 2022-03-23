package com.meezu.androidapparchitectureassignment.features.addTask

import com.hannesdorfmann.mosby3.mvp.MvpView
import com.meezu.androidapparchitectureassignment.features.shared.model.response.AddTaskResponse
import com.meezu.androidapparchitectureassignment.features.shared.model.response.TaskResponse

interface AddTaskView: MvpView {

    fun saveTask(addTaskResponse: AddTaskResponse)
    fun showErrorMessage(localizedMessage: String?)
}