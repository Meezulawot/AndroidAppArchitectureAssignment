package com.meezu.androidapparchitectureassignment.features.task

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.hannesdorfmann.mosby3.mvp.MvpActivity
import com.meezu.androidapparchitectureassignment.R
import com.meezu.androidapparchitectureassignment.features.shared.adapter.TaskAdapter
import com.meezu.androidapparchitectureassignment.features.shared.model.response.TaskResponse
import kotlinx.android.synthetic.main.activity_main.*

class TaskActivity : MvpActivity<TaskView, TaskPresenter>(), TaskView, View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.getTasks()
        initListener()
    }

    override fun createPresenter(): TaskPresenter {
        return TaskPresenter()
    }

    override fun setTasks(tasksList: ArrayList<TaskResponse>) {
        runOnUiThread {
            setRecyclerView(tasksList)
        }
    }

    override fun showErrorMessage(localizedMessage: String?) {
        Toast.makeText(this, "$localizedMessage", Toast.LENGTH_SHORT).show()
    }

    private fun setRecyclerView(tasksList: ArrayList<TaskResponse>){
        val adapter = TaskAdapter(tasksList, this)
        rcvTask.layoutManager = LinearLayoutManager(this)
        rcvTask.adapter = adapter
    }

    private fun initListener(){
        fabAdd.setOnClickListener (this)
    }

    override fun onClick(p0: View?) {
        when(p0){
            fabAdd->{
                startActivity(Intent(this, AddTaskActivity::class.java))
            }
        }
    }
}