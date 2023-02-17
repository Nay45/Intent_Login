package com.example.ukllagi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ktCard(private val listBarang: ArrayList<Data_Barang>): RecyclerView.Adapter<ktCard.GridViewHolder>() {

    class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvFrom: TextView = itemView.findViewById(R.id.tv_item_desc)
        var tvPrice: TextView = itemView.findViewById(R.id.tv_item_price)
        var btnFav: Button = itemView.findViewById(R.id.btn_set_fav)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val (name, from, price, photo) = listBarang[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)

        holder.tvName.text = name
        holder.tvFrom.text = from
        holder.tvPrice.text = price

        holder.btnFav.setOnClickListener{
            Toast.makeText(holder.itemView.context, "Add to fav " + listBarang[position].nama, Toast.LENGTH_SHORT).show()
        }

        holder.itemView.setOnClickListener{
            Toast.makeText(holder.itemView.context, "U choose " + listBarang[position].nama, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return listBarang.size
    }

}
