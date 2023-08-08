package com.example.month7hw1.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.month7hw1.R
import com.example.month7hw1.presentation.ui.UiState
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<WayViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getWays()
    }

    private fun getWays() {
        viewModel.getAllWay
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getAllWay.collect() {
                    when (it) {
                        is UiState.Loading -> {
                            print("Show progress bar")
                        }

                        is UiState.Empty -> {}
                        is UiState.Error -> {
                            Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_SHORT).show()
                        }

                        is UiState.Success -> {
                            println("Show data or rv")
                        }
                    }
                }
            }

        }
    }
}