package com.example.hiltsample

import javax.inject.Inject
import javax.inject.Qualifier

interface Engine {
    fun start()
    fun shutdown()
}

class GasEngine @Inject constructor() : Engine {
    override fun start() {
        println("Gas engine start.")
    }

    override fun shutdown() {
        println("Gas engine shutdown.")
    }
}

class ElectricEngine @Inject constructor() : Engine {
    override fun start() {
        println("Electric engine start.")
    }

    override fun shutdown() {
        println("Electric engine shutdown.")
    }
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BindGasEngine

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BindElectricEngine