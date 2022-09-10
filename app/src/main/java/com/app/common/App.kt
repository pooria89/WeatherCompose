package com.app.common

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    override fun getApplicationContext(): Context {
        return super.getApplicationContext()
    }
}