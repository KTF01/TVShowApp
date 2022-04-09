package com.example.tvshowapp.ui.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tvshowapp.model.TVShow

class DetailViewModel(application:Application):AndroidViewModel(application) {

    private val tvShow:LiveData<TVShow> = MutableLiveData();

}
