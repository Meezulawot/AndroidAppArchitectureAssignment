package com.meezu.androidapparchitectureassignment.features.addTask

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.hannesdorfmann.mosby3.mvp.MvpActivity
import com.meezu.androidapparchitectureassignment.R
import com.meezu.androidapparchitectureassignment.features.shared.model.response.AddTaskResponse
import kotlinx.android.synthetic.main.activity_add_task.*

class AddTaskActivity : MvpActivity<AddTaskView, AddTaskPresenter>(), AddTaskView, View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)
        initListener()
    }

    override fun createPresenter(): AddTaskPresenter {
        return AddTaskPresenter()
    }

    override fun saveTask(addTaskResponse: AddTaskResponse) {
        Toast.makeText(this, "${addTaskResponse.message}", Toast.LENGTH_SHORT).show()
    }

    override fun showErrorMessage(localizedMessage: String?) {
        Toast.makeText(this, "$localizedMessage", Toast.LENGTH_SHORT).show()
    }

    private fun initListener(){
       btnSave.setOnClickListener (this)
       edtDate.setOnClickListener (this)
    }

    override fun onClick(p0: View?) {
        when(p0){
            btnSave->{
                presenter.addTask()
//                startActivity(Intent(this, TaskActivity::class.java))
            }
        }
    }
}