package com.example.demomvvm

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView


class MyToolBar : RelativeLayout, View.OnClickListener {
    private lateinit var mTxtTitle: TextView
    private lateinit var mBtnBack: ImageView

    private var mListener : ToolbarClick?=null

    constructor(context: Context?) : super(context) {
        addView(context, null)
    }


    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        addView(context, attrs)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        addView(context, attrs)
    }

    private fun addView(context: Context?, attrs: AttributeSet?) {
        val v = LayoutInflater.from(context).inflate(R.layout.layout_toolbar, this)
        mTxtTitle = v.findViewById(R.id.txt_title)
        mBtnBack = v.findViewById(R.id.btn_back)
        mBtnBack.setOnClickListener(this)

        val typeArray = context?.obtainStyledAttributes(attrs, R.styleable.MyToolBar)
        val n = typeArray?.indexCount
        n?.let {
            for (i in 0 until n) {
                when (val attr = typeArray.getIndex(i)) {
                    R.styleable.MyToolBar_title -> {
                        mTxtTitle.text = typeArray.getString(attr)
                    }
                }
            }
        }
    }

    fun setTile(text: String?) {
        mTxtTitle.text = text
    }

    fun setToolbarListener(listener : ToolbarClick){
        mListener=listener
    }


    interface ToolbarClick{
        fun clickBack()
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_back->{
                mListener?.clickBack()
            }
        }
    }

}