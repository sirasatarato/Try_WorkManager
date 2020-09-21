package com.silso.try_workmanager

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val workManager: WorkManager = WorkManager.getInstance(application.applicationContext)
    private val request: OneTimeWorkRequest =
        OneTimeWorkRequest.Builder(ProgressWorker::class.java).build()

    

    fun startProgress() {
        workManager.enqueue(request)
    }
}