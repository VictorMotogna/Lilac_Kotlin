package com.victormotogna.flowers.koin

import com.victormotogna.flowers.viewmodels.MainViewModel
import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.Module

object AppModules {
    private val viewModelModule: Module = org.koin.dsl.module.applicationContext {
        viewModel { MainViewModel() }
    }
    val modules = listOf(viewModelModule)
}