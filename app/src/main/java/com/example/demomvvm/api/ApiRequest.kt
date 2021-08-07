package com.example.demomvvm.api

import com.example.demomvvm.LoadCategoryWithPost2Response
import com.example.demomvvm.request.LoadCategoryWithPost2Request
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiRequest {
    @POST("LoadCategoryWithPost2")
    fun loadCategoryWithPost2(@Body requestDataList: LoadCategoryWithPost2Request): Observable<LoadCategoryWithPost2Response>

}