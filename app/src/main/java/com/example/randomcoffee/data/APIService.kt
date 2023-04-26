package com.example.randomcoffee.data

import com.example.randomcoffee.data.dto.DtoCoffee
import retrofit2.http.GET

interface APIService {

    @GET("random.json")
    suspend fun getRandomCaffe():DtoCoffee
}