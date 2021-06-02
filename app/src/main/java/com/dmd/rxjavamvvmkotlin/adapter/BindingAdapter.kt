package com.dmd.rxjavamvvmkotlin.adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.dmd.rxjavamvvmkotlin.R
import com.dmd.rxjavamvvmkotlin.models.Data

object BindingAdapter {
    @JvmStatic
    @BindingAdapter("app:userList")
    fun setUserList(recyclerView: RecyclerView, data: List<Data>?){
        if (recyclerView.adapter == null){
            val userAdapter = UserAdapter()
            recyclerView.adapter = userAdapter
        }

        data?.let {
            (recyclerView.adapter as UserAdapter).updateList(it)
        }

    }

    @JvmStatic
    @BindingAdapter("app:src")
    fun setSrc(imageView: ImageView, url: String){
        if (url.isNotEmpty()){
            Glide.with(imageView.context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView)
        } else {
            Glide.with(imageView.context).load(R.drawable.pika).into(imageView)
        }
    }

    @JvmStatic
    @BindingAdapter("app:nameAndSurname")
    fun setNameAndSurname(textView: TextView, data: Data){
        val valueToArrange = "${data.first_name} ${data.last_name}"
        textView.apply {
            text = valueToArrange
        }
    }


}