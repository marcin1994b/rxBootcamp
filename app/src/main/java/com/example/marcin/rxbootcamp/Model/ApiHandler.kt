package com.example.marcin.rxbootcamp.Model

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Marcin on 20.09.2017.
 */
class ApiHandler() {

    interface ApiInterface{

        @GET("posts")
        fun getPosts(@Query("search") text: String) : Observable<List<Post>>

        @GET("users/{id}")
        fun getAuthor(@Path("id") id: Int) : Observable<Author>
    }

    private object APIClient {

        val BASIC_URL : String = "https://thedroidsonroids.com/wp-json/wp/v2/"
        var retrofit : Retrofit

        init {
            retrofit = Retrofit.Builder()
                    .baseUrl(BASIC_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build()
        }
    }

    private val apiClient: ApiInterface = APIClient.retrofit.create(ApiInterface::class.java)

    fun getPosts(text: String) : Observable<List<Post>> = apiClient.getPosts(text)

    fun getAuthor(id: Int) : Observable<Author> = apiClient.getAuthor(id)

}