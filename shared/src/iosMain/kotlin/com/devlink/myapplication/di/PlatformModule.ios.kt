package com.devlink.myapplication.di

actual val platformModule = m {
    // Or use Compiler Plugin DSL / Annotations if no custom logic needed
    single<IosPlatformHelper>() bind PlatformHelper::class
    single<IosDatabaseDriver>() bind DatabaseDriver::class
}