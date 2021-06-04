package com.dmd.rxjavamvvmkotlin.models

import java.io.Serializable

data class Data( //Converted to Parcelable for intentUtil put Extra
    val avatar: String,
    val email: String,
    val first_name: String,
    val id: Int,
    val last_name: String
) : Serializable