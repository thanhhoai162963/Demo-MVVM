package com.example.demomvvm.repository

import com.example.demomvvm.LoadCategoryWithPost2Response
import com.example.demomvvm.api.RetrofitInit
import com.example.demomvvm.request.LoadCategoryWithPost2Request
import io.reactivex.rxjava3.core.Observable

object DetailRepository {

    fun getDetail(request: LoadCategoryWithPost2Request): Observable<LoadCategoryWithPost2Response> {
        return RetrofitInit.instance.getApiService().loadCategoryWithPost2(request)
    }
}