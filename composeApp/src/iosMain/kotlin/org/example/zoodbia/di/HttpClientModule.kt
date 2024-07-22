package org.example.zoodbia.di

import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin
import org.koin.dsl.module

actual val httpClientModule = module {
    single { HttpClient(Darwin) {
        // TODO handle for iOS
    } }
}