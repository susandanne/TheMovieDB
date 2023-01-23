package com.example.themoviedb.api

import androidx.constraintlayout.widget.R
import com.example.themoviedb.latestDatamodel.ResponseLatestMovies
import com.example.themoviedb.model.ResponseUpcomingMovie
import com.example.themoviedb.ui.Constant.key
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("3/movie/upcoming?api_key=$key")

    suspend fun getdata(
        @Query("language") language: String,
        @Query("page") page:Int

    ):ResponseUpcomingMovie

    @GET("3/movie/latest?api_key=$key")
    suspend fun getlatestMoviedata(

    ): Response<ResponseLatestMovies>
}