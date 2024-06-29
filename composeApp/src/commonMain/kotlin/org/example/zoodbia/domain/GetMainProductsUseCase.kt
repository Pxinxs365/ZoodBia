package org.example.zoodbia.domain

import org.example.zoodbia.data.ProductsRepository

class GetMainProductsUseCase(
    private val productsRepository: ProductsRepository
) {

    fun execute() = productsRepository.getMainProducts()
}