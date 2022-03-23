package com.meezu.androidapparchitectureassignment.features.task

import android.annotation.SuppressLint
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.meezu.androidapparchitectureassignment.features.shared.model.response.AddTaskResponse
import com.meezu.androidapparchitectureassignment.features.shared.model.response.TaskResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AddTaskPresenter: MvpBasePresenter<AddTaskView>() {

    private var  taskInteractor : TaskInteractor? = null

    override fun attachView(view: AddTaskView) {
        super.attachView(view)
        taskInteractor = TaskInteractor()
    }

    override fun detachView() {
        super.detachView()
        taskInteractor = TaskInteractor()
    }

    @SuppressLint("CheckResult")
    fun addTask(){
        taskInteractor?.addTask()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe({
                handleSuccess(it)
            }, {
                handleError(it.localizedMessage)
            })
    }

    private fun handleSuccess(addTaskResponse: AddTaskResponse) {
        ifViewAttached { view ->
            view.saveTask(addTaskResponse)
        }
    }

    private fun handleError(localizedMessage: String?){
        ifViewAttached { view ->
            view.showErrorMessage(localizedMessage)
        }
    }

}