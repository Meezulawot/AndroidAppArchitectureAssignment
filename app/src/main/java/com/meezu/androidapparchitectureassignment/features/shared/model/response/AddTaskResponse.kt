package com.meezu.androidapparchitectureassignment.features.shared.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AddTaskResponse {

    @SerializedName("message")
    @Expose
    val message: String? = null
}