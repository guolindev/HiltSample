package com.example.hiltsample

import javax.inject.Inject

class Truck @Inject constructor(private val driver: Driver) {

    @BindGasEngine
    @Inject
    lateinit var gasEngine: Engine

    @BindElectricEngine
    @Inject
    lateinit var electricEngine: Engine

    fun deliver() {
        gasEngine.start()
        electricEngine.start()
        println("Truck is delivering cargo. Driven by $driver")
        gasEngine.shutdown()
        electricEngine.shutdown()
    }

}