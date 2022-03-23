package com.meezu.androidapparchitectureassignment.features.shared.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.meezu.androidapparchitectureassignment.R
import com.meezu.androidapparchitectureassignment.features.shared.model.response.TaskResponse
import kotlinx.android.synthetic.main.layout_custom_task.view.*
import okhttp3.internal.concurrent.Task

class TaskAdapter (
    val lsttask: ArrayList<TaskResponse>,
    val context: Context
): RecyclerView.Adapter<TaskAdapter.TaskVH>() {

    class TaskVH(view: View): RecyclerView.ViewHolder(view){
        var task= view.txvTitle
        var date= view.txvDate

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_custom_task, parent, false)
        return TaskVH(view)
    }

    override fun onBindViewHolder(holder: TaskVH, position: Int) {
        val task = lsttask[position]
        holder.task.text = task.taskDescription
        holder.date.text = task.dueDate
    }

    override fun getItemCount(): Int {
        return lsttask.size
    }
}