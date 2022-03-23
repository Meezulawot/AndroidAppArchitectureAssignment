package com.meezu.androidapparchitectureassignment.features.task

import android.annotation.SuppressLint
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.meezu.androidapparchitectureassignment.features.shared.model.response.TaskResponse
import com.meezu.androidapparchitectureassignment.utils.constants.ApiConstants.getTasks
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class TaskPresenter: MvpBasePresenter<TaskView>() {

    private var  taskInteractor : TaskInteractor? = null

    override fun attachView(view: TaskView) {
        super.attachView(view)
        taskInteractor = TaskInteractor()
    }

    override fun detachView() {
        super.detachView()
        taskInteractor = TaskInteractor()
    }

    @SuppressLint("CheckResult")
    fun getTasks(){
        taskInteractor?.getTasks()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe({
                handleSuccess(it)
            }, {
                handleError(it.localizedMessage)
            })
    }

    private fun handleSuccess(taskResponse: ArrayList<TaskResponse>){
        ifViewAttached { view ->
            view.setTasks(taskResponse)
        }
    }

    private fun handleError(localizedMessage: String?){
        ifViewAttached { view ->
            view.showErrorMessage(localizedMessage)
        }
    }

}