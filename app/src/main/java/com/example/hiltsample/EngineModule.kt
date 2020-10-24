package com.example.hiltsample

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class EngineModule {

    @BindGasEngine
    @Binds
    abstract fun bindGasEngine(gasEngine: GasEngine): Engine

    @BindElectricEngine
    @Binds
    abstract fun bindElectricEngine(electricEngine: ElectricEngine): Engine

}