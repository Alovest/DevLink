package com.devlink.myapplication.app.di

import com.devlink.myapplication.app.presentation.viewmodel.AuthRegisterViewModel
import com.devlink.myapplication.data.local.SessionManager
import com.devlink.myapplication.di.data.dataModule
import com.devlink.myapplication.di.domain.domainModule
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import org.koin.plugin.module.dsl.viewModel
import kotlin.coroutines.EmptyCoroutineContext.get

val presentationModule = module {

    viewModel{
        AuthRegisterViewModel(
            get(),
            get()
        )
    }

}

val appModules = listOf(presentationModule, dataModule, domainModule)