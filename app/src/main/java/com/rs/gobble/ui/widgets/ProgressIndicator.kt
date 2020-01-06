package com.rs.gobble.ui.widgets

import androidx.compose.*
import androidx.ui.layout.Arrangement
import androidx.ui.layout.ExpandedWidth
import androidx.ui.layout.Row
import androidx.ui.material.CircularProgressIndicator

@Composable
fun progressIndicator() {
    Row(ExpandedWidth, arrangement = Arrangement.SpaceEvenly) {
        CircularProgressIndicator(progress = 0.9f)
    }
}