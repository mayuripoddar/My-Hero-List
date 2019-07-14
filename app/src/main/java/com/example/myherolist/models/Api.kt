package com.example.myherolist.models

import retrofit2.Call
import retrofit2.http.GET

/**
 * author mayuri
 * To make an API call using retrofit we need a java interface where we define all the URLs with the http request type and parameters. Here, we will perform an http GET with no extra parameters.
 */

interface Api {

    @get:GET("marvel")
    val heroes: Call<List<Hero>>

    companion object {

        val BASE_URL = "https://simplifiedcoding.net/demos/"
    }
}
