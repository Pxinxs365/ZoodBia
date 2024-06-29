package org.example.zoodbia.di

import org.example.zoodbia.ui.main.MainViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val viewModelModule = module {
    singleOf(::MainViewModel)
}