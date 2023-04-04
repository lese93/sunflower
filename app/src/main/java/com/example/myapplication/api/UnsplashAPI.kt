package com.example.myapplication.api

import com.example.myapplication.data.UnsplashResp
import okhttp3.OkHttpClient

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface UnsplashAPI {

    @GET("search/photos")
    suspend fun searchPhotos(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
        @Query("client_id") clientId: String = "MvH0s48wMV8XW3eGmqUUhrBfl3UcIgHZJC83FxQ4hSM"
    ): UnsplashResp

    companion object {
        private const val BASE_URL = "https://api.unsplash.com/"

        fun create(): UnsplashAPI {
//            val logger = HttpLoggingInterceptor().apply { level = Level.BASIC }

            val client = OkHttpClient.Builder()
//                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(UnsplashAPI::class.java)
        }
    }
}