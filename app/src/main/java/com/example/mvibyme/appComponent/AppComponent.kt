package com.example.mvibyme.appComponent

import com.example.mvibyme.activities.MainActivity
import com.example.mvibyme.appModule.RequestModule
import com.example.mvibyme.recyclerview.MoviesRecycler
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(RequestModule::class))
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(moviesRecycler: MoviesRecycler)
}