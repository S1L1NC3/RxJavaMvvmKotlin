package com.dmd.rxjavamvvmkotlin.util

import android.content.Context
import android.content.Intent
import android.os.Parcelable
import com.dmd.rxjavamvvmkotlin.constants.Constants


class IntentUtil {

    fun openIntent(from: Context, to: Class<*>){
        val intent = Intent(from, to)
        from.startActivity(intent)
    }

    fun openIntentWithExtra(from: Context, to: Class<*>, extra: Parcelable){
        val intent = Intent(from, to).apply {
            putExtra(Constants.EXTRA_KEY, extra)
        }
        from.startActivity(intent)

    }
}