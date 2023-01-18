package com.example.themoviedb.ui

object Util {
    fun posterUrlMake(uri: Any?): String {
        return "https://image.tmdb.org/t/p/w780$uri"
    }
}