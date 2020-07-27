package com.example.mvibyme.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvibyme.App
import com.example.mvibyme.R
import com.example.mvibyme.recyclerview.MoviesRecycler
import com.example.mvibyme.modelRequest.Results
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers.io
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var results: Flowable<ArrayList<Results>>

    lateinit var moviesRecycler: MoviesRecycler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as App).getComponent().inject(this)

        results.subscribeOn(io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {res ->
                recycler.apply {
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    moviesRecycler = MoviesRecycler(res, this@MainActivity)
                    adapter = moviesRecycler
                }
            }
    }



///**no borrar*/
//    private var disposable: Disposable? = null
//
//    private val service by lazy {
//        Service.create()
//    }
//
//
//    fun loadInfo() {
//        disposable = service.getMovies(this.getString(R.string.api_key))
//                .subscribeOn(io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe (
//                    {result ->
//                        Log.d("INFO", "${result.total_pages}")
//                        result
//                    },
//                    { error ->  Log.d("INFO", "${error}")
//                    }
//                )
//    }
}