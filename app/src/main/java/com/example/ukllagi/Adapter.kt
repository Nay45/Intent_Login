package com.example.ukllagi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter (private val context: Context, private val items: ArrayList<MyData>):
    RecyclerView.Adapter<Adapter.ViewHolder>(){
    class ViewHolder (itemView:View):RecyclerView.ViewHolder(itemView){
        private var txtFriendName: TextView = itemView.findViewById(R.id.txtName)
        private var txtFriendEmail: TextView = itemView.findViewById(R.id.txtEmail)
        private var txtFriendDate: TextView = itemView.findViewById(R.id.txtDate)

        fun bindItem(item: MyData) {
            txtFriendName.text = item.nama
            txtFriendEmail.text = item.email
            txtFriendDate.text = item.date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater
        .from(context).inflate(R.layout.listdata, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items.get(position))
    }

    override fun getItemCount(): Int = items.size
}