package com.jdm.app.dbtestapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DBTestApp: Application() {
    override fun onCreate() {
        super.onCreate()
        pref = PreferenceHelperImpl(applicationContext)
    }
    companion object {
        lateinit var pref: PreferenceHelperImpl
    }
}