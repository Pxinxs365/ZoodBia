package org.example.zoodbia

import android.app.Application
import org.example.zoodbia.di.KoinInitializer

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        KoinInitializer(applicationContext).init()
    }
}