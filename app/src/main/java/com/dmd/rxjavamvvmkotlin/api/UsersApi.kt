package com.dmd.rxjavamvvmkotlin.api

import com.dmd.rxjavamvvmkotlin.constants.Constants
import com.dmd.rxjavamvvmkotlin.models.UsersResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersApi {
    @GET(Constants.API_ENDPOINT)
    suspend fun getUsers(
        @Query(Constants.API_PARAMETER) per_page: String
    ) : Response<UsersResponse>
}