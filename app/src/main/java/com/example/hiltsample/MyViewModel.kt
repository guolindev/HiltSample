package com.example.hiltsample

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel

class MyViewModel @ViewModelInject constructor(private val repository: Repository) : ViewModel() {

    fun doWork() {
        repository.doRepositoryWork()
    }

}