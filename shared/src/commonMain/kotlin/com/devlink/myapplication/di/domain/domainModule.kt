package com.devlink.myapplication.di.domain

import com.devlink.myapplication.domain.usecase.auth.AuthRegisterPasswordAndEmailUsecase
import com.devlink.myapplication.domain.usecase.auth.AuthRegisterUsernameUsecase
import org.koin.dsl.module

val domainModule = module {
    factory {
        AuthRegisterPasswordAndEmailUsecase(
            get()
        )
    }

    factory {
        AuthRegisterUsernameUsecase(
            get()
        )
    }
}