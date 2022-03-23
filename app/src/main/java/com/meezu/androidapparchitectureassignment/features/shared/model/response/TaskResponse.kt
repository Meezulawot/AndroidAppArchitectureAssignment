package com.meezu.androidapparchitectureassignment.features.shared.model.response

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class TaskResponse {

//    @SerializedName("taskId")
//    @Expose
//    val taskId: Int? = null

    @SerializedName("taskDescription")
    @Expose
    val taskDescription: String? = null

    @SerializedName("dueDate")
    @Expose
    val dueDate: String? = null
}