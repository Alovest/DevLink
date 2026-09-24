package com.devlink.myapplication.app.di

import com.devlink.myapplication.di.data.dataModule
import com.devlink.myapplication.di.domain.domainModule
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

val presentationModule = module {

}

val appModules = listOf(presentationModule, dataModule, domainModule)