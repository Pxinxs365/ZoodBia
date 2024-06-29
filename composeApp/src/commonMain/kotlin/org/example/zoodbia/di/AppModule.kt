package org.example.zoodbia.di

import org.example.zoodbia.data.ProductsRepository
import org.example.zoodbia.domain.GetMainProductsUseCase
import org.koin.dsl.module

val appModule = module {

}

val useCasesModule = module {
    factory { GetMainProductsUseCase(get()) }
}

val repositoriesModule = module {
    single { ProductsRepository() }
}