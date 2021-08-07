package com.example.demomvvm

import com.google.gson.annotations.Expose
import kotlinx.serialization.SerialName

class Data {
    @SerialName("pageSize")
    @Expose
    val pageSize: Int? = null

    @SerialName("total")
    @Expose
    val total: Int? = null

    @SerialName("list")
    @Expose
    val list: List<ListCategory>? = null
}