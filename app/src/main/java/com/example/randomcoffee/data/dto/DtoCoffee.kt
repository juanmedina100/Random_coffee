package com.example.randomcoffee.data.dto

import com.google.gson.annotations.SerializedName

data class DtoCoffee(
   @SerializedName("file") var file: String
    //@SerializedName("`file`") var file: String

)