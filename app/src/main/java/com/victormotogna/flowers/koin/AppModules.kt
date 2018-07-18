package com.victormotogna.flowers.koin

import com.victormotogna.flowers.MainViewModel
import com.victormotogna.flowers.api.FlowersApi
import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object AppModules {
    private val retrofitModule: Module = applicationContext {
        bean {
            Retrofit.Builder()
                    .baseUrl("https://demo9997383.mockable.io/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
                    .create(FlowersApi::class.java)
        }

        bean { FlowersApi::class }
    }

    private val viewModelModule: Module = applicationContext {
        viewModel { MainViewModel() }
    }

    val modules = listOf(retrofitModule, viewModelModule)

}