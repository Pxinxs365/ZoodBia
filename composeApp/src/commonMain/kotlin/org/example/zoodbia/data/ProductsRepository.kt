package org.example.zoodbia.data

class ProductsRepository(
    // TODO: inject dependencies to fetch from remote
) {

    fun getMainProducts(): List<String> {
        return listOf(
            "Apple",
            "Orange",
            "Cherry",
            "Blackberry"
        )
    }
}