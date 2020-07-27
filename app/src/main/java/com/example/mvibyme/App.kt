package com.example.mvibyme


import android.app.Application
import com.example.mvibyme.appComponent.AppComponent
import com.example.mvibyme.appComponent.DaggerAppComponent


class App: Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build()
    }

    fun getComponent() = appComponent
}