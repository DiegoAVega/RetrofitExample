package com.example.retrofitexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CustomAdapter(private val listOfCards: List<CardModel>, private val context: Context): RecyclerView.Adapter<CustomViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_item, parent, false)

        return CustomViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listOfCards.size

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.nameView.text=listOfCards[position].name
        holder.descriptionView.text=listOfCards[position].description
        Glide.with(context).load(listOfCards[position].imageUrl).into(holder.imageView)
    }

}

class CustomViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val imageView:ImageView
    val nameView:TextView
    val descriptionView:TextView

    init{
        imageView=view.findViewById(R.id.imageViewCard)
        nameView=view.findViewById(R.id.textViewCardName)
        descriptionView=view.findViewById(R.id.textViewCardDescription)
    }
}

class CardModel(val imageUrl:String, val description:String, val name:String)