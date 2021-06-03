package com.dmd.rxjavamvvmkotlin.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmd.rxjavamvvmkotlin.data.UserRepository
import com.dmd.rxjavamvvmkotlin.models.UsersResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: UserRepository
): ViewModel(){
    private val _response = MutableLiveData<UsersResponse>()
    val dataError = MutableLiveData<Boolean>()
    val dataLoading = MutableLiveData<Boolean>()
    val dataSuccess = MutableLiveData<Boolean>()

    val responseUsers: LiveData<UsersResponse>
        get() = _response

    init { //on initialize
        getUsers()
    }

    fun refreshData(){ //Might be helpful for swipe refresh, and it did
        getUsers()
    }


    private fun getUsers() = viewModelScope.launch {
        dataLoading.postValue(true) //Coroutine start -> loading
        repository.getUsers().let {response ->
            if (response.isSuccessful){
                _response.postValue(response.body())
                dataSuccess.postValue(true) // success -> true
                dataError.postValue(false) // success -> error -> false
                dataLoading.postValue(false) // success -> loading -> false
            }else{
                dataSuccess.postValue(false) // success -> false
                dataError.postValue(true)  // error -> true
                dataLoading.postValue(false) // loading -> false
            }
        }
    }
}