package com.example.mvibyme.modelRequest

import java.io.Serializable

data class Model (
    val page: Int,
    val total_results: Long,
    val total_pages: Int,
    val results: ArrayList<Result>): Serializable