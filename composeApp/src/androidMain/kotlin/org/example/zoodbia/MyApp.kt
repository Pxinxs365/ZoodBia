package org.example.zoodbia

import android.app.Application
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import isDebug
import org.example.zoodbia.di.KoinInitializer

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        KoinInitializer(applicationContext).init()

        // consider moving to appropriate file
        if (isDebug()) {
            Napier.base(DebugAntilog())
        }
    }
}