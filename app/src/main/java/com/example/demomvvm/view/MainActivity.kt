package com.example.demomvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demomvvm.CategorySub
import com.example.demomvvm.R
import com.example.demomvvm.adapter.ArticalAdapter
import com.example.demomvvm.request.LoadCategoryWithPost2Request
import com.example.demomvvm.viewmodel.MainViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private lateinit var mMainViewModel: MainViewModel
    private lateinit var mAdapter: ArticalAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_test.setOnClickListener {
            setViewModel()
        }

    }

    private fun setViewModel() {
        mMainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        lifecycle.addObserver(mMainViewModel)
        mMainViewModel.getDetail.observe(this) {
            setAdapter(it.data?.list?.get(0)?.list)
        }
        mMainViewModel.callApiDetail(
            LoadCategoryWithPost2Request(
                categoryType = 1,
                language = 1,
                page = 1,
                pageSize = 10
            )
        )
        button_test.visibility = View.GONE
    }


    private fun setAdapter(listArtical: List<CategorySub>?) {
        val mLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerview.layoutManager = mLayoutManager
        mAdapter = ArticalAdapter()
        listArtical?.let { mAdapter!!.setData(it, this) }
        recyclerview.apply {
            adapter = mAdapter
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    DividerItemDecoration.VERTICAL
                )
            )
        }
    }
}
