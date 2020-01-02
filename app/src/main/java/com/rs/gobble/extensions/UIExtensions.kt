package com.rs.gobble.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun AppCompatActivity?.replaceFragment(containerViewId: Int, fragment: Fragment) {
    this?.supportFragmentManager?.beginTransaction()
        ?.replace(containerViewId, fragment, fragment::class.java.name)?.commit()
}