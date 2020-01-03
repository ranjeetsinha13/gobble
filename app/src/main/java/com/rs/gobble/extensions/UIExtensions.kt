package com.rs.gobble.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.effectOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun AppCompatActivity?.replaceFragment(containerViewId: Int, fragment: Fragment) {
    this?.supportFragmentManager?.beginTransaction()
        ?.replace(containerViewId, fragment, fragment::class.java.name)?.commit()
}

fun <T> LiveData<T>.observeData() = effectOf<T?> {
    val result = +androidx.compose.state<T?> { this@observeData.value }
    val observer = +androidx.compose.memo { Observer<T> { result.value = it } }

    +androidx.compose.onCommit(this@observeData) {
        this@observeData.observeForever(observer)
        onDispose { this@observeData.removeObserver(observer) }
    }
    result.value
}