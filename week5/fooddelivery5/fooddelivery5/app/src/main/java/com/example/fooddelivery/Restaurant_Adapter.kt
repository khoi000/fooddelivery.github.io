package com.example.fooddelivery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.model.Restaurant


class Restaurant_Adapter(var dataSet: List<Restaurant>) : RecyclerView.Adapter<Restaurant_Adapter.RestaurantViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        return RestaurantViewHolder.form(parent)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
       val res = dataSet[position]
        holder.bindData(res)
    }

    override fun getItemCount(): Int {
       return dataSet.size
    }

    class RestaurantViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        companion object {
            fun form(parent: ViewGroup): RestaurantViewHolder{
                var layoutInflater = LayoutInflater.from(parent.context)
                var view = layoutInflater.inflate(R.layout.item_view_restaurant,parent,false)
                return RestaurantViewHolder(view)
            }
        }

        fun bindData(res: Restaurant){
            val id_res = itemView.findViewById<TextView>(R.id.id_restaurant)
            val name_res = itemView.findViewById<TextView>(R.id.name_res)
            val address_of_res = itemView.findViewById<TextView>(R.id.address_of_res)
            val avatar = itemView.findViewById<ImageView>(R.id.avata_res)

            avatar.setImageResource(res.avatar)
            name_res.text = res.name
            address_of_res.text = res.address
            id_res.text = res.id.toString()




        }

    }
}