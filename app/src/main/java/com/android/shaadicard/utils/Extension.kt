package com.android.shaadicard.utils

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat
import com.android.shaadicard.R

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun AppCompatTextView.green() {
    setTextColor(ResourcesCompat.getColor(resources, R.color.green, null))
}

fun AppCompatTextView.red() {
    setTextColor(ResourcesCompat.getColor(resources, R.color.red, null))
}