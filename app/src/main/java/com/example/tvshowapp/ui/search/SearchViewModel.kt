package com.example.tvshowapp.ui.search

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.tvshowapp.database.AppDatabase
import com.example.tvshowapp.network.TvShowType
import com.example.tvshowapp.repository.TVShowApiRepository
import com.example.tvshowapp.repository.TVShowRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SearchViewModel(application:Application):AndroidViewModel(application) {
    private val repository : TVShowApiRepository = TVShowApiRepository()
    private lateinit var repositoryDB : TVShowRepository
    var loadedShows by mutableStateOf<List<TvShowType>>(emptyList())
    private val _showDialog = MutableStateFlow(false)
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()
    val showDialog: StateFlow<Boolean> = _showDialog.asStateFlow()
    private var debouncePeriod: Long = 500
    private var searchJob: Job? = null

    var selectedShow:TvShowType? = null


    init {
        val showDao = AppDatabase.getInstance(application).tvShowDao()
        repositoryDB = TVShowRepository(showDao)
    }

    fun onTextBoxTextChanged(query: String){
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(debouncePeriod)
            searchShows(query)
        }
    }

    private fun searchShows(keyword:String) {
        _isLoading.value=true
        viewModelScope.launch(Dispatchers.IO) {
            val shows = repository.fetchShows(keyword)
            if (shows != null) {
                loadedShows = shows
            }
            _isLoading.value=false
        }
    }

    fun onOpenDialogClicked(show:TvShowType) {
        selectedShow = show
        _showDialog.value = true
    }

    fun onDialogConfirm() {
        viewModelScope.launch (Dispatchers.IO ){
            repositoryDB.insertIntoFavs(selectedShow!!)
        }
        _showDialog.value = false

    }

    fun onDialogDismiss() {
        _showDialog.value = false
    }
}