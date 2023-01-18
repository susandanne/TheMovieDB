package com.example.themoviedb.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.themoviedb.repo.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModel@Inject constructor(private val  repo: Repo) : ViewModel() {
val listdataviewmodel=repo.getallapirepo().cachedIn(viewModelScope)
    val latestmoviesVMLD=repo.latestMovie
    fun latestmovieVM()=repo.getLatestMovie()
}
