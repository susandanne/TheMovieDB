package com.example.themoviedb.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.liveData
import com.example.themoviedb.api.Api
import com.example.themoviedb.latestDatamodel.ResponseLatest
import com.example.themoviedb.paging.PagingData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class Repo @Inject constructor(private val api:Api) {
 fun getallapirepo()=Pager(
config = PagingConfig(pageSize =20, maxSize = 100),
pagingSourceFactory = {PagingData(api)}
 ).liveData

 private var _latestMovie = MutableLiveData<ResponseLatest>()
 val latestMovie: LiveData<ResponseLatest>
  get() = _latestMovie

 fun getLatestMovie() {

  GlobalScope.launch {
   val response = api.getlatestMoviedata()
   if (response.isSuccessful) {
    _latestMovie.postValue(response.body())
   }
  }
 }
}