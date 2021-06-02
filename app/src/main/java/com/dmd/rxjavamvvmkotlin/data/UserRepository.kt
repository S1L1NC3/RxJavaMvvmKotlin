package com.dmd.rxjavamvvmkotlin.data

import com.dmd.rxjavamvvmkotlin.api.UsersApi
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(private var api: UsersApi){
    @Inject
    @Named("pageCount")
    lateinit var pageCount: String //DI used for much more cleaner code

    suspend fun getUsers() = api.getUsers(pageCount)
}