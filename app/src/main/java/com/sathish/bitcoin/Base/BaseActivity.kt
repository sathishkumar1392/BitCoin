package com.sathish.bitcoin.Base

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.*
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity<T : ViewDataBinding> :
    DaggerAppCompatActivity() {

    abstract fun onActivityCreated(dataBinder: T)

    abstract fun getLayoutId(): Int

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this@BaseActivity.initial()
    }

    private fun initial() {
        this@BaseActivity.getLayoutId().let { layoutId ->
            val dataBinder = DataBindingUtil.setContentView<T>(this@BaseActivity, layoutId)
            this@BaseActivity.onActivityCreated(dataBinder)
        }
    }

}