package com.example.streamchatdemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.streamchatdemo.databinding.UserRowLayoutBinding
import io.getstream.chat.android.client.ChatClient
import io.getstream.chat.android.client.models.User

class UsersAdapter : RecyclerView.Adapter<UsersAdapter.MyViewHolder>() {

    private val client = ChatClient.instance()
    private var userList = emptyList<User>()


    class MyViewHolder(val binding: UserRowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            UserRowLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentUser = userList[position]
    }

    override fun getItemCount(): Int {
        return userList.size
    }


}