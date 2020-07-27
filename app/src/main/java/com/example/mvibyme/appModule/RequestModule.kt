package com.example.mvibyme.appModule


import com.example.mvibyme.modelRequest.Results
import com.example.mvibyme.modelRequest.Service
import dagger.Module
import dagger.Provides
import io.reactivex.Flowable
import javax.inject.Singleton

@Module
class RequestModule {

    val service by lazy {
        Service.create()
    }

    @Provides
    @Singleton
    fun providesModel(): Flowable<ArrayList<Results>> {
        return service.getMovies("b133c1180758351bf9a6631f15a7457f").map { model -> return@map model.results }
    }
}