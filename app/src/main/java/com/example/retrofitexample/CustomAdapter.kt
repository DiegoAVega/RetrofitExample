package com.example.retrofitexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(val listOfCards: List<CardModel>): RecyclerView.Adapter<CustomViewHolder>(){
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

class CardModel(val image:String, val description:String, val name:String)