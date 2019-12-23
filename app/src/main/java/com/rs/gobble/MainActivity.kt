package com.rs.gobble

import android.app.Activity
import android.os.Bundle
import androidx.ui.core.setContent
import com.rs.gobble.ui.GobbleApp

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GobbleApp(resources)
        }
    }
}