package com.example.retrofitexample

import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET


interface RetrofitService {
    @GET("cardinfo.php")
    suspend fun getCards(): Response<CardResponse>

}

class CardResponse(
    val data: List<Card>
)

class Card(
    val name: String,
    val type: String,
    @SerializedName("desc")
    val description: String,
    @SerializedName("card_images")
    val cardImages: List<CardImage>
)

class CardImage(
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("image_url_small")
    val imageUrlSmall: String
)
object RetrofitServiceFactory {

    fun makeRetrofitService(): RetrofitService {
        return Retrofit.Builder()
            .baseUrl("https://db.ygoprodeck.com/api/v7/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitService::class.java)
    }

}