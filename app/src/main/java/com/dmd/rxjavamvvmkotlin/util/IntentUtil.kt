package com.dmd.rxjavamvvmkotlin.util

import android.content.Context
import android.content.Intent
import com.dmd.rxjavamvvmkotlin.constants.Constants
import com.dmd.rxjavamvvmkotlin.models.Data


class IntentUtil {
    fun openIntentWithExtra(from: Context, to: Class<*>, extra: Data){
        val intent = Intent(from, to)
        intent.putExtra(Constants.EXTRA_KEY, extra)
        from.startActivity(intent)
    }
}