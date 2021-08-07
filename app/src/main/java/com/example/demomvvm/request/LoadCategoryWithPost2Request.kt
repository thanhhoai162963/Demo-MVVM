package com.example.demomvvm.request

import com.google.gson.annotations.Expose
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoadCategoryWithPost2Request(

    @SerialName("categoryType")
    @Expose
    val categoryType: Int? = null,

    @SerialName("language")
    @Expose
    val language: Int? = null,

    @SerialName("page")
    @Expose
    val page: Int? = null,

    @SerialName("pageSize")
    @Expose
    val pageSize: Int? = null
)