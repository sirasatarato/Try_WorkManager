package com.silso.try_workmanager

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager

class MainViewModel(application: Application) : AndroidViewModel(application) {
    var workManager: WorkManager = WorkManager.getInstance(application.applicationContext)

    fun startProgress() {
        val request: OneTimeWorkRequest =
            OneTimeWorkRequest.Builder(ProgressWorker::class.java).build()
    }
}