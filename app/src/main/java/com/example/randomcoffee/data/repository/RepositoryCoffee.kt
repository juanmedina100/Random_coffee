package com.example.randomcoffee.data.repository

import android.util.Log
import com.example.randomcoffee.data.APIService
import com.example.randomcoffee.data.dto.DtoCoffee
import java.lang.Exception
import javax.inject.Inject

class RepositoryCoffee @Inject constructor(
    private val apiService: APIService
){

    suspend fun getRandomCaffe(): Result<DtoCoffee>{
        return try {
            Log.i("caffee","REPO :::: ${apiService.getRandomCaffe()}")
            Result.success(apiService.getRandomCaffe())
        } catch (e:Exception){
            Log.i("caffee","REPO ERROR:::: ${e.message}")
            Result.failure(e)
        }
    }

}