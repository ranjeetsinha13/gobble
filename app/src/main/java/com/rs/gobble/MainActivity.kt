package com.rs.gobble

import android.app.Activity
import android.os.Bundle
import androidx.compose.unaryPlus
import androidx.ui.core.*
import com.rs.gobble.ui.GobbleApp

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GobbleApp(resources)
        }
    }
}