package com.example.mvibyme.activities

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.mvibyme.R
import com.example.mvibyme.modelRequest.Result

class MovieDetailsActivity : AppCompatActivity() {

    lateinit var movieDetailsImage: ImageView
    lateinit var movieDetailsTitle: TextView
    lateinit var movieDetailsOverview: TextView
    lateinit var result: Result

    private val POSTER_URL = "https://image.tmdb.org/t/p/original"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        bindElements()

        Log.d("INFO", "details are ${result.vote_count} ===============")

    }


    fun bindElements() {
        movieDetailsImage = findViewById(R.id.movie_details_image)
        movieDetailsTitle = findViewById(R.id.movie_details_title)
        movieDetailsOverview = findViewById(R.id.movie_details_overview)
        result = intent.getSerializableExtra("Result") as Result

        movieDetailsOverview.text = result.overview
        movieDetailsTitle.text = result.title

        Glide.with(this)
            .load(POSTER_URL + result.poster_path)
            .into(movieDetailsImage)
    }
}