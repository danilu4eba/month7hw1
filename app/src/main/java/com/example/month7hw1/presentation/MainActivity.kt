package com.example.month7hw1.presentation

import android.os.Bundle
import androidx.activity.viewModels
import com.example.month7hw1.R
import com.example.month7hw1.presentation.base.BaseActivity


class MainActivity : BaseActivity() {

    private val viewModel by viewModels<WayViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getWays()
    }

    private fun getWays() {
        viewModel.getAll()

        viewModel.getAllWay.collectInfo(
            loadingState = {
                           println("Show progress bar")
            },
            successState = {   println("$it")},
            emptyState = {println("is empty")},
            errorState = {println("some error $it")}
        )

    }
}