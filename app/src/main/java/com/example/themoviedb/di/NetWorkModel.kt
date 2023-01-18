package com.example.themoviedb.di

import com.example.themoviedb.api.Api
import com.example.themoviedb.ui.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetWorkModel {
    @Singleton
    @Provides
fun getRetrofit():Retrofit.Builder{
    return Retrofit.Builder().baseUrl(Constant.base_url).addConverterFactory(GsonConverterFactory.create())
}
   @Singleton
   @Provides
    fun retrofitApi(retrofit: Retrofit.Builder):Api{
        return retrofit.build().create(Api::class.java)
    }
}