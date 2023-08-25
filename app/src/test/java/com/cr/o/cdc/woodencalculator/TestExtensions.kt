package com.cr.o.cdc.woodencalculator

import android.text.Editable

fun String.toEditable() = Editable.Factory.getInstance().newEditable(this)