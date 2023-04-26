package com.example.randomcoffee.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomcoffee.data.dto.DtoCoffee
import com.example.randomcoffee.data.repository.RepositoryCoffee
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CaffeeViewModel @Inject constructor(
    private val repositoryCoffee: RepositoryCoffee
) :ViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    var loading=_loading

    private val _caffee = MutableLiveData<DtoCoffee>()
    var caffee = _caffee

    fun getRamdom(){
        _loading.postValue(true)
        viewModelScope.launch(Dispatchers.IO) {
            repositoryCoffee.getRandomCaffe().onSuccess {
                _loading.postValue(false)
                _caffee.postValue(it)
            }.onFailure {
            }
        }
    }

}