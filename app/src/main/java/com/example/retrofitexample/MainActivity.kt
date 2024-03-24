package com.example.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    val listCard = mutableListOf<CardModel>()

    val service = RetrofitServiceFactory.makeRetrofitService()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        lifecycleScope.launch {
            val response = service.getCards()
            if (response.isSuccessful) {
                val cardResponse = response.body()
                if (cardResponse != null) {
                    cardResponse.data.forEach {
                        listCard.add(CardModel(it.cardImages.first().imageUrl,it.description,it.name))
                    }
                    recyclerView.adapter?.notifyDataSetChanged()
                }
            } else {
                println("error")
            }
        }

    }

    fun initRecyclerView() {
        recyclerView=findViewById(R.id.recyclerView)
        recyclerView.adapter=CustomAdapter(listCard, this)
    }

}