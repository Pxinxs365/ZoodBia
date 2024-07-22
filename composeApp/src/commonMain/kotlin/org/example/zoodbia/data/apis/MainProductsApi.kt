package org.example.zoodbia.data.apis

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.serialization.Serializable

class MainProductsApi(
    private val httpClient: HttpClient
) {

    suspend fun getMainProducts(): List<DataObjItem> =
        httpClient.get("/posts").body()

    @Serializable
    data class DataObjItem(
        val userId: Int?,
        val id: Int?,
        val title: String?,
        val body: String?
    )
}