package com.silso.try_workmanager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class ProgressWorker(context: Context, workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {

    override fun doWork(): Result {

        return Result.success()
    }
}