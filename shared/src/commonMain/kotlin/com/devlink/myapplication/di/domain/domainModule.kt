package com.devlink.myapplication.di.domain

import com.devlink.myapplication.data.repository.AuthRepositoryImpl
import com.devlink.myapplication.domain.repository.AuthRepository
import com.devlink.myapplication.domain.usecase.AuthRegisterUsecase
import org.koin.dsl.module

val domainModule = module {
    factory { AuthRegisterUsecase(get()) }
}