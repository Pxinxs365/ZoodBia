package org.example.zoodbia.data.repositories

import io.github.aakira.napier.Napier
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import org.example.zoodbia.data.apis.MainProductsApi

class ProductsRepository(
    private val mainProductsApi: MainProductsApi
) {

    suspend fun getMainProducts(): List<String> {
        return runCatching {
            withContext(Dispatchers.IO) { mainProductsApi.getMainProducts().map { it.title ?: "" } }
        }.onSuccess {
            Napier.d("getMainProducts success: ${it.first()}")
        }.onFailure {
            // TODO handle an exception
            Napier.d("getMainProducts exception: $it")
        }.getOrThrow()
    }
}