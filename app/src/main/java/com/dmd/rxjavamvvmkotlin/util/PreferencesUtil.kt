package com.dmd.rxjavamvvmkotlin.util

import android.content.Context
import android.util.Log
import com.dmd.rxjavamvvmkotlin.BuildConfig
import com.dmd.rxjavamvvmkotlin.constants.Constants
import com.dmd.rxjavamvvmkotlin.models.Data
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PreferencesUtil {

    fun putObject(context: Context, list: List<Data>){
        val preferences = context.getSharedPreferences(BuildConfig.APPLICATION_ID,Context.MODE_PRIVATE)
        val valueToPut = Gson().toJson(list)
        Log.d("ServiceResponseTag", "jsonString Track: \n$valueToPut")
        preferences.edit().putString(Constants.SHARED_PREF_KEY, valueToPut).apply()
    }

    fun retrieveObject(context: Context): List<Data> {
        val preferences = context.getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE)
        val jsonString = preferences.getString(Constants.SHARED_PREF_KEY, Constants.DEFAULT_SHARED_PREF)
        val typeToken = object : TypeToken<List<Data>>(){}.type
        Log.d("ServiceResponseTag", "jsonString Track: \n$jsonString")
        return Gson().fromJson(jsonString, typeToken)
    }
}