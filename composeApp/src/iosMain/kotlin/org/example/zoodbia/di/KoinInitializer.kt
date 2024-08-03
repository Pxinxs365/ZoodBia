package org.example.zoodbia.di

import org.koin.core.context.startKoin

actual class KoinInitializer {
    actual fun init() {
        startKoin {
            modules(
                appModule,
                viewModelModule,
                useCasesModule,
                repositoriesModule,
                apisModule,
                httpClientModule
            )
        }
    }
}