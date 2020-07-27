package com.example.mvibyme.modelRequest

import java.io.Serializable

data class Results(
    val popularity: Double,
    val vote_count: Int,
    val video: Boolean,
    val poster_path: String,
    val title: String,
    val original_title: String,
    val release_date: String,
    val overview: String): Serializable