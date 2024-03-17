package com.example.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val service = RetrofitServiceFactory.makeRetrofitService()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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

}