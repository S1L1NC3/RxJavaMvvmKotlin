package com.dmd.rxjavamvvmkotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dmd.rxjavamvvmkotlin.databinding.RowUserBinding
import com.dmd.rxjavamvvmkotlin.models.Data

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>(){
    private var adapterDataList: ArrayList<Data> = arrayListOf()

    class UserViewHolder(val binding: RowUserBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RowUserBinding.inflate(layoutInflater)

        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentUser = adapterDataList[position]
        holder.binding.user = currentUser
    }

    fun updateList(newDataList: List<Data>) {
        adapterDataList.clear()
        adapterDataList.addAll(newDataList)
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return adapterDataList.size
    }
}