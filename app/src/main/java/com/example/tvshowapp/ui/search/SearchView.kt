package com.example.tvshowapp.ui.search

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tvshowapp.model.TVShow

class SearchView:ComponentActivity() {
    private val keyword:LiveData<String> = MutableLiveData("");
    private val searchResult: LiveData<List<TVShow>> = MutableLiveData();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}