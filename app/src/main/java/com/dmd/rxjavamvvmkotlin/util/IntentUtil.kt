package com.dmd.rxjavamvvmkotlin.util

import android.content.Context
import android.content.Intent
import com.dmd.rxjavamvvmkotlin.constants.Constants
import com.dmd.rxjavamvvmkotlin.models.Data


class IntentUtil {

    fun openIntent(from: Context, to: Class<*>){
        val intent = Intent(from, to)
        from.startActivity(intent)
    }

    fun openIntentWithExtra(from: Context, to: Class<*>, extra: Data){
        val intent = Intent(from, to)
        intent.putExtra(Constants.EXTRA_KEY, extra)
        from.startActivity(intent)
    }
}