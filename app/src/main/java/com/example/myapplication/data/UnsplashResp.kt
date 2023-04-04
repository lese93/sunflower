package com.example.myapplication.data

data class UnsplashResp(
    val total : Int,
    val total_pages : Int,
    val results : List<UnsplashResult>
)