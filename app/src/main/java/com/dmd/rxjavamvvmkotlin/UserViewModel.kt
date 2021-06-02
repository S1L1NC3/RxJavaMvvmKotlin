package com.dmd.rxjavamvvmkotlin

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
    val responseUsers: LiveData<UsersResponse>
        get() = _response

    init {
        getUsers()
    }

    fun refreshData(){ //Might be helpful for swipe refresh
        getUsers()
    }

    private fun getUsers() = viewModelScope.launch {
        repository.getUsers().let {response ->
            if (response.isSuccessful){
                _response.postValue(response.body())
            }else{
                Log.d("ServiceResponseTag", "getUsers Error: ${response.code()}")
            }
        }
    }
}