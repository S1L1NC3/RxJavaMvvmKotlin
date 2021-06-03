package com.dmd.rxjavamvvmkotlin.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Data( //Converted to Parcelable for intentUtil put Extra
    val avatar: String,
    val email: String,
    val first_name: String,
    val id: Int,
    val last_name: String
) : Parcelable