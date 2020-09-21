package com.silso.try_workmanager

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        do_work_button.setOnClickListener{
            viewModel.startProgress()
        }

        viewModel.progressData.observe(this, {
            val progress: Int = it.progress.getInt("work", 0)
            progressBar.progress = progress
            show_progress_rate_text.text = "$progress%"
        })
    }
}