package com.sathish.bitcoin.ui

import com.sathish.bitcoin.Base.BaseActivity
import com.sathish.bitcoin.R
import com.sathish.bitcoin.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private lateinit var binding: ActivityMainBinding

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onActivityCreated(dataBinder: ActivityMainBinding) {
        binding = dataBinder
    }
}
