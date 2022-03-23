package com.meezu.androidapparchitectureassignment.features.task

import com.meezu.androidapparchitectureassignment.features.shared.model.response.TaskResponse
import com.meezu.androidapparchitectureassignment.features.shared.repository.TaskRepository

class TaskInteractor {

    fun getTasks() = TaskRepository().getAllTasks()
    fun addTask() = TaskRepository().addTask()
}