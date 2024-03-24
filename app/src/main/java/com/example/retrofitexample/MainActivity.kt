package com.example.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

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
                    println("SE IMPRIME RESPONSE: ${cardResponse.data.first().cardImages.first().imageUrl}")
                }
            } else {
                println("error")
            }
        }

    }

    fun initRecyclerView(){
        val listOfCards:List<CardModel> = listOf(
            CardModel("https://images.ygoprodeck.com/images/cards/10286023.jpg", "If this card is Special Summoned by the effect of an \"Adamancipator\" card: You can draw 1 card. If this card is in your GY: You can target 1 WATER Synchro Monster you control or in your GY; return it to the Extra Deck, and if you do, place this card on top of the Deck. You can only use each effect of \"Adamancipator Crystal - Dragite\" once per turn.","Adamancipator Crystal - Dragite"),
            CardModel("", "If this card is Special Summoned by the effect of an \"Adamancipator\" card: You can draw 1 card. If this card is in your GY: You can target 1 WATER Synchro Monster you control or in your GY; return it to the Extra Deck, and if you do, place this card on top of the Deck. You can only use each effect of \"Adamancipator Crystal - Dragite\" once per turn.","Adamancipator Crystal - Dragite")

        )
        recyclerView=findViewById(R.id.recyclerView)
        recyclerView.adapter=CustomAdapter(listOfCards, this)
    }

}