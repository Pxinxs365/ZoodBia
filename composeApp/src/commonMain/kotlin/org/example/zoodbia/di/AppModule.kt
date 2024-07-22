package org.example.zoodbia.di

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import org.example.zoodbia.data.apis.MainProductsApi
import org.example.zoodbia.data.repositories.ProductsRepository
import org.example.zoodbia.domain.usecases.GetMainProductsUseCase
import org.koin.dsl.module

val appModule = module {
    // TODO: base app configs (for example timestamp dependency)
    Napier.base(DebugAntilog())
}

val useCasesModule = module {
    factory { GetMainProductsUseCase(get()) }
}

val repositoriesModule = module {
    single { ProductsRepository(get()) }
}

val apisModule = module {
    single { MainProductsApi(get()) }
}