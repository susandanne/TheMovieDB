package com.example.themoviedb.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.themoviedb.api.Api
import com.example.themoviedb.model.MovieResult

class PagingData(private val api: Api) : PagingSource<Int, MovieResult>() {
    override fun getRefreshKey(state: PagingState<Int, MovieResult>): Int? {
      return state.anchorPosition?.let {
          state.closestPageToPosition(it)?.prevKey?.plus(1)
              ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
      }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieResult> {
        return try {
            val position = params.key ?: 1

            val response = api.getdata("en-US",position)

            LoadResult.Page(
               data= response.movieResults,
               prevKey =  if (position == 1) null else position - 1,
               nextKey =  if (position == response.totalPages) null else position + 1
            )
        } catch (e: java.lang.Exception) {
            LoadResult.Error(e)
        }
    }
}