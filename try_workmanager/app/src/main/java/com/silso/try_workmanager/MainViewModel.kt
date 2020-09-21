package com.silso.try_workmanager

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkInfo
import androidx.work.WorkManager

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val workManager: WorkManager = WorkManager.getInstance(application.applicationContext)
    private val request: OneTimeWorkRequest =
        OneTimeWorkRequest.Builder(ProgressWorker::class.java).build()

    var progressData: LiveData<WorkInfo> = workManager.getWorkInfoByIdLiveData(request.id)

    fun startProgress() {
        workManager.enqueue(request)
    }
}