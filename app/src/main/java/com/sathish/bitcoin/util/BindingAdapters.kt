package com.sathish.bitcoin.util

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("showIf")
fun showIf(view : View, show : Boolean) {
    if (show) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}

