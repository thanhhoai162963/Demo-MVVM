package com.example.demomvvm.viewmodel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demomvvm.LoadCategoryWithPost2Response
import com.example.demomvvm.repository.DetailRepository
import com.example.demomvvm.request.LoadCategoryWithPost2Request
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel : ViewModel(), LifecycleObserver {
    private val _detail: MutableLiveData<LoadCategoryWithPost2Response> = MutableLiveData()
    val getDetail: LiveData<LoadCategoryWithPost2Response> get() = _detail

    fun callApiDetail(requestDataDetail: LoadCategoryWithPost2Request) {
        DetailRepository
            .getDetail(requestDataDetail)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<LoadCategoryWithPost2Response> {
                override fun onSubscribe(d: Disposable?) {
                }

                override fun onNext(t: LoadCategoryWithPost2Response?) {
                    _detail.value = t
                }

                override fun onError(e: Throwable?) {
                }

                override fun onComplete() {
                }

            })
    }
}