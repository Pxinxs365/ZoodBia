package org.example.zoodbia.domain.usecases

import org.example.zoodbia.data.repositories.ProductsRepository

class GetMainProductsUseCase(
    private val productsRepository: ProductsRepository
) {

    suspend fun execute() = productsRepository.getMainProducts()
}