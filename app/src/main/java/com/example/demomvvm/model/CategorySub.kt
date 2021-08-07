package com.example.demomvvm

import com.google.gson.annotations.Expose
import kotlinx.serialization.SerialName

class CategorySub {
    @SerialName("postSignature")
    @Expose
    val postSignature: String? = null

    @SerialName("title")
    @Expose
    val title: String? = null

    @SerialName("onDate")
    @Expose
    val onDate:String? = null

    @SerialName("avatar")
    val avatar:String? = null

}