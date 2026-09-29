package com.devlink.myapplication.app.di

import com.devlink.myapplication.app.presentation.viewmodel.auth.AuthRegisterViewModel
import com.devlink.myapplication.di.data.dataModule
import com.devlink.myapplication.di.domain.domainModule
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel{
        AuthRegisterViewModel(
            get(),
            get(),
            get()
        )
    }
}

val appModules = listOf(presentationModule, dataModule, domainModule)