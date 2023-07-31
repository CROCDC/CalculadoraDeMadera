package com.example.woodencalculator.utils

import android.text.Editable
import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<T>.setValueIfNotNull(value: T?) {
    if (value != null) {
        this.value = value
    }
}

fun Editable?.toInt() = this.takeIf {
    !it.isNullOrBlank()
}?.toString()?.toInt()